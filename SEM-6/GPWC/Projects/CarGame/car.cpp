#include <SFML/Graphics.hpp>
#include <iostream>
#include <sstream>
#include <vector>
#include <ctime>
using namespace sf;
using namespace std;

/*
---------------- PLAYER CAR ----------------
*/ 
class PlayerCar {
private:
   Texture texture;
   Sprite sprite;

public:
   PlayerCar() {
       texture.loadFromFile("Assets/WhiteCar.png");
       sprite.setTexture(texture);
       sprite.setScale(0.5f, 0.5f);
       sprite.setPosition(220, 600);
   }

   void move(float dx) {
       sprite.move(dx, 0);

       // LEFT LIMIT
       if (sprite.getPosition().x < 100) {
           sprite.setPosition(100, sprite.getPosition().y);
       }

       // RIGHT LIMIT
       float rightLimit = 410 - sprite.getGlobalBounds().width;

       if (sprite.getPosition().x > rightLimit) {
           sprite.setPosition(rightLimit,sprite.getPosition().y);
       }
   }

   Sprite& getSprite() {
       return sprite;
   }
};

/*
---------------- ENEMY CAR ----------------
*/ 
class EnemyCar {
private:
   static Texture textures[5];
   static bool loaded;
   Sprite sprite;

public:
   EnemyCar(float x, float y) {
       if (!loaded) {
           textures[0].loadFromFile("Assets/RedCar1.png");
           textures[1].loadFromFile("Assets/RedCar2.png");
           textures[2].loadFromFile("Assets/YellowCar1.png");
           textures[3].loadFromFile("Assets/YellowCar2.png");
           textures[4].loadFromFile("Assets/YellowCar3.png");
           loaded = true;
       }
       sprite.setTexture(textures[rand() % 5]);
       sprite.setScale(0.5f, 0.5f);
       sprite.setPosition(x, y);
   }

   void update(float speed) {
       sprite.move(0, speed);
   }

   Sprite& getSprite() {
       return sprite;
   }
};

Texture EnemyCar::textures[5];
bool EnemyCar::loaded = false;

/*
---------------- MAIN ----------------
*/ 
int main() {
   srand(time(0));
   RenderWindow window(VideoMode(500, 800),"Car Dodging Game");
   window.setFramerateLimit(60);

   // ---------------- ROAD DIVIDERS ----------------
   RectangleShape divider[12];
   for (int i = 0; i < 12; i++) {
       divider[i].setSize(Vector2f(10, 50));
       divider[i].setFillColor(Color::White);
       divider[i].setPosition(245, -80 + (i * 80));
   }
   float dividerSpeed = 300;

   // ---------------- PLAYER ----------------
   PlayerCar player;

   // ---------------- ENEMIES ----------------
   vector<EnemyCar> enemies;
   float lanes[] = {120, 190, 260, 330};
   for (int i = 0; i < 6; i++) {
       enemies.push_back(EnemyCar(lanes[rand() % 4],-200.0f * i));
   }

   // ---------------- GAME VARIABLES ----------------
   float enemySpeed = 300;
   int score = 0;
   int gameSpeed = 1;
   bool gameOver = false;
   bool paused = false;
   bool acceptInput = true;

   // ---------------- FONT ----------------
   Font font;
   font.loadFromFile("KOMIKAP_.ttf");
   Text scoreText;
   Text speedText;
   Text message;
   scoreText.setFont(font);
   speedText.setFont(font);
   message.setFont(font);
   scoreText.setCharacterSize(20);
   speedText.setCharacterSize(20);
   message.setCharacterSize(32);
   scoreText.setPosition(20, 20);
   speedText.setPosition(330, 20);
   message.setFillColor(Color::White);

   Clock clock;

   /*
   ---------------- GAME LOOP ----------------
   */ 
   while (window.isOpen()) {
       float delta = clock.restart().asSeconds();
       Event event;
       while (window.pollEvent(event)) {
           if (event.type == Event::Closed) {
               window.close();
           }
           if (event.type == Event::KeyReleased) {
               acceptInput = true;
           }

           // RESTART
           if (event.type == Event::KeyPressed && event.key.code == Keyboard::Enter && gameOver) {
               enemies.clear();
               for (int i = 0; i < 6; i++) {
                   enemies.push_back(EnemyCar(lanes[rand() % 4], -200.0f * i));
               }
               player.getSprite().setPosition(220, 600);
               score = 0;
               gameSpeed = 1;
               enemySpeed = 300;
               paused = false;
               gameOver = false;
               message.setString("");
           }
       }

       // ---------------- PAUSE ----------------
       if (Keyboard::isKeyPressed(Keyboard::Space) && acceptInput) {
           paused = !paused;
           acceptInput = false;
       }

       // ---------------- PLAYER MOVEMENT ----------------
       if (!paused && !gameOver) {
           if (Keyboard::isKeyPressed(Keyboard::Left)) {
               player.move(-350 * delta);
           }
           if (Keyboard::isKeyPressed(Keyboard::Right)) {
               player.move(350 * delta);
           }
       }

       // ------------ UPDATE DIVIDERS ----------------
       if (!paused && !gameOver) {
           // ROAD DIVIDER MOVEMENT
           for (int i = 0; i < 12; i++) {
               float y = divider[i].getPosition().y;
               y += dividerSpeed * delta;
               if (y > 800) {
                   y = -80;
               }
               divider[i].setPosition(245, y);
           }

           // ENEMY CAR MOVEMENT
           for (auto &e : enemies) {
               e.update(enemySpeed * delta);
               float x = e.getSprite().getPosition().x;
               float y = e.getSprite().getPosition().y;
               if (y > 850) {
                   y = -200;
                   x = lanes[rand() % 4];
                   score++;
                   if (score % 10 == 0) {
                       gameSpeed++;
                       enemySpeed += 40;
                   }
               }
               e.getSprite().setPosition(x, y);
           }

           // COLLISION OF ENEMY WITH PLAYER
           for (auto &e : enemies) {
               if (e.getSprite().getGlobalBounds().intersects(player.getSprite().getGlobalBounds())) {
                   gameOver = true;
                   paused = true;
               }
           }
       }

       // ---------------- SCORE TEXT ----------------
       stringstream ss;
       ss << "Score : " << score;
       scoreText.setString(ss.str());

       // ---------------- SPEED TEXT ----------------
       stringstream ss2;
       ss2 << "Speed : " << gameSpeed;
       speedText.setString(ss2.str());

       // ---------------- MESSAGE TEXT ----------------
       if (gameOver) {
           message.setString("GAME OVER\nPress ENTER");
       }
       else if (paused) {
           message.setString("PAUSED");
       }
       else {
           message.setString("");
       }

       // CNTERING THE MESSAGE TEXT
       FloatRect bounds = message.getLocalBounds();
       message.setOrigin(bounds.left + bounds.width / 2.0f,bounds.top + bounds.height / 2.0f);
       message.setPosition(window.getSize().x / 2.0f,window.getSize().y / 2.0f);

       // ---------------- DRAW ----------------
       window.clear(Color::Black);

       // ROAD
       RectangleShape road(Vector2f(320, 800));
       road.setFillColor(Color(40, 40, 40));
       road.setPosition(90, 0);
       window.draw(road);

       // DIVIDERS
       for (int i = 0; i < 12; i++) {
           window.draw(divider[i]);
       }

       // ENEMIES
       for (auto &e : enemies) {
           window.draw(e.getSprite());
       }

       // PLAYER
       window.draw(player.getSprite());

       // UI
       window.draw(scoreText);
       window.draw(speedText);
       window.draw(message);

       window.display();
   }
   return 0;
}
