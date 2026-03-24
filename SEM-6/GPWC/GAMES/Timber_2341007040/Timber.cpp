#include <SFML/Graphics.hpp>
#include <sstream>
using namespace sf;

void updateBranches(int seed);
const int NUM_BRANCHES = 6;
Sprite branches[NUM_BRANCHES];
// Where is the player/branch?
// Left or Right
enum class side{LEFT, RIGHT, NONE};
side branchPosition[NUM_BRANCHES];

int main() {
	VideoMode vm(1920, 1080);
	RenderWindow window (vm, "Timber!!");
	View view(FloatRect(0,0,1920,1080));
	window.setView(view);
	
	
	//CREATING BACKGROUND :- 
	Texture textureBackground;
	textureBackground.loadFromFile("graphics/background.png");
	Sprite spriteBackground;
	spriteBackground.setTexture(textureBackground);
	spriteBackground.setPosition(0,0);
	
	
	//CREATING TREE :-
	Texture textureTree;
	textureTree.loadFromFile("graphics/tree.png");
	Sprite spriteTree;
	spriteTree.setTexture(textureTree);
	spriteTree.setPosition(810,0);
	
	
	//CREATING CLOUDS :-
	Texture textureCloud;
	textureCloud.loadFromFile("graphics/cloud.png");
	Sprite spriteCloud1;
	Sprite spriteCloud2;
	Sprite spriteCloud3;
	spriteCloud1.setTexture(textureCloud);
	spriteCloud2.setTexture(textureCloud);
	spriteCloud3.setTexture(textureCloud);
	spriteCloud1.setPosition(0,0);
	spriteCloud2.setPosition(0,250);
	spriteCloud3.setPosition(0,500);
	bool cloud1Active = false;
	bool cloud2Active = false;
	bool cloud3Active = false;
	float cloud1Speed = 0.0f;
	float cloud2Speed = 0.0f;
	float cloud3Speed = 0.0f;
	
	
	//CREATING BEE :-
	Texture textureBee;
	textureBee.loadFromFile("graphics/bee.png");
	Sprite spriteBee;
	spriteBee.setTexture(textureBee);
	spriteBee.setPosition(0,800);
	bool beeActive = false;
	float beeSpeed = 0.0f;
	
	
	//CRETING PLAYER :-
	Texture texturePlayer;
	texturePlayer.loadFromFile("graphics/player.png");
	Sprite spritePlayer;
	spritePlayer.setTexture(texturePlayer);
	spritePlayer.setPosition(580,720);
	
	//GRAVE STONE :-
	Texture textureRIP;
	textureRIP.loadFromFile("graphics/rip.png");
	Sprite spriteRIP;
	spriteRIP.setTexture(textureRIP);
	spriteRIP.setPosition(580,770);
	
	
	//CRETING AXE :-
	Texture textureAxe;
	textureAxe.loadFromFile("graphics/axe.png");
	Sprite spriteAxe;
	spriteAxe.setTexture(textureAxe);
	spriteAxe.setPosition(700,830);
	const float AXE_POSITION_LEFT = 700;
	const float AXE_POSITION_RIGHT = 1075;
	
	
	//CREATING LOG :-
	Texture textureLog;
	textureLog.loadFromFile("graphics/log.png");
	Sprite spriteLog;
	spriteLog.setTexture(textureLog);
	spriteLog.setPosition(810, 720);
	bool logActive = false;
	float logSpeedX = 1000;
	float logSpeedY = -1500;
	
	Clock clock;
	
	// TIME BAR :-
	RectangleShape timeBar;
	float timeBarStartWidth = 400;
	float timeBarHeight = 80;
	timeBar.setSize(Vector2f(timeBarStartWidth, timeBarHeight));
	timeBar.setFillColor(Color::Red);
	timeBar.setPosition(1920/2 - timeBarStartWidth/2, 980);
	Time gameTimeTotal;
	float timeRemaining = 6.0f;
	float timeBarWidthPerSecond = timeBarStartWidth / timeRemaining;
	
	//Track whether the game is running :-
	bool paused = true;
	
	//SCORE VARIABLE :-
	int score = 0;
	
	//TEXT OBJECT :-
	Text messageText;
	Text scoreText;
	
	Font font;
	font.loadFromFile("font/KOMIKAP_.ttf");
	messageText.setFont(font);
	scoreText.setFont(font);
	messageText.setString("Press Enter to start!");
	scoreText.setString("Score =0");
	messageText.setCharacterSize(75);
	scoreText.setCharacterSize(100);
	messageText.setFillColor(Color::White);
	scoreText.setFillColor(Color::White);
	// Position the text :-
	FloatRect textRect = messageText.getLocalBounds();
	messageText.setOrigin(textRect.left + textRect.width/2.0f, textRect.top + textRect.height / 2.0f);
	messageText.setPosition(1920/2.0f, 1080/2.0f);
	scoreText.setPosition(20,20);
	
	//PREPARE 6 BRANCHES :-
	Texture textureBranch;
	textureBranch.loadFromFile("graphics/branch.png");
	for(int i = 0; i < NUM_BRANCHES; i++) {
		branches[i].setTexture(textureBranch);
		branches[i].setPosition(-2000,-2000);
		branches[i].setOrigin(220,40);
	}
	
	
	//MAIN GAME LOOP :-
	while(window.isOpen()) {
		Event event;
		while(window.pollEvent(event)) {
			if(event.type == Event::Closed) {
				window.close();
			}
		}
		if(Keyboard::isKeyPressed(Keyboard::Escape)) {
			window.close();
		}
		if(Keyboard::isKeyPressed(Keyboard::Return)) {
			paused = false;
			timeRemaining = 6;
			score = 0;
		}
		
		
		if(!paused) {
			//update the scene
			Time dt = clock.restart();
			timeRemaining -= dt.asSeconds();
			timeBar.setSize(Vector2f(timeBarWidthPerSecond * timeRemaining, timeBarHeight));
			if(timeRemaining <= 0.0f) {
				paused = true;
				messageText.setString("Out of time");
				FloatRect textRect = messageText.getLocalBounds();
				messageText.setOrigin(textRect.left + textRect.width/2.0f, textRect.top + textRect.height / 2.0f);
				messageText.setPosition(1920/2.0f, 1080/2.0f);
			}
				
			//BEE Movement :-
			if(!beeActive){
				srand((int)time(0));//access the the current time
				beeSpeed=(rand()%200)+200;//0-399
				srand((int)time(0)*10);
				float height=(rand()%500)+500;//to set the height 0-999
				spriteBee.setPosition(2000,height); 
				beeActive=true;
			}else{	
				//move bee
				spriteBee.setPosition(spriteBee.getPosition().x - (beeSpeed*dt.asSeconds()), spriteBee.getPosition().y);
				//to make bee to left again			
				if(spriteBee.getPosition().x < -100){
					beeActive=false;
				}
			}
		
			//CLOUD-1 Movement :-
			if(!cloud1Active) {
				srand((int)time(0));
				cloud1Speed = (rand() % 200) + 100;
				srand((int)time(0) * 10);
				float height = (rand() % 150);
				spriteCloud1.setPosition(-300, height);
				cloud1Active = true;
			}else {
				//move cloud 1 :-
				spriteCloud1.setPosition(spriteCloud1.getPosition().x + (cloud1Speed*dt.asSeconds()), spriteCloud1.getPosition().y);
				if(spriteCloud1.getPosition().x > 1920) {
					cloud1Active = false;
				}
			}
		
			//CLOUD-2 Movement :-
			if(!cloud2Active) {
				srand((int)time(0) * 20);
				cloud2Speed = (rand() % 200) + 100;
				srand((int)time(0)*20);
				float height = (rand() % 300) - 150;
				spriteCloud2.setPosition(-300, height);
				cloud2Active = true;
			}else {
				//move cloud 2 :-toffe share
				spriteCloud2.setPosition(spriteCloud2.getPosition().x + (cloud2Speed*dt.asSeconds()), spriteCloud2.getPosition().y);
				if(spriteCloud2.getPosition().x > 1920) {
					cloud2Active = false;
				}
			}
		
			//CLOUD-3 Movement :-
			if(!cloud3Active) {
				srand((int)time(0)*30);
				cloud3Speed = (rand() % 200) + 100;
				srand((int)time(0) * 30);
				float height = (rand() % 450) - 150;
				spriteCloud3.setPosition(-300, height);
				cloud3Active = true;
			}else {
				//move cloud 3 :-
				spriteCloud3.setPosition(spriteCloud3.getPosition().x + (cloud3Speed*dt.asSeconds()), spriteCloud3.getPosition().y);
				if(spriteCloud3.getPosition().x > 1920) {
					cloud3Active = false;
				}
			}
			
			//SCORE UPDATE :-
			std::stringstream ss;
			ss<<"Score = "<<score;
			scoreText.setString(ss.str());
			
			// update the branch sprites
			for(int i = 0; i < NUM_BRANCHES; i++) {
				float height = i * 150;
				if(branchPosition[i] == side::LEFT) {
					branches[i].setPosition(610, height);  
					branches[i].setRotation(180);
				}else if(branchPosition[i] == side::RIGHT) {
					branches[i].setPosition(1310, height);
					branches[i].setRotation(0);
				}else {
					branches[i].setPosition(3000, height);
				}
			}
			
			
			//end of if(!pause) block.
		}
		
		//DRAW THE SCENE :-
		window.clear();
		window.draw(spriteBackground);
		window.draw(spriteCloud1);
		window.draw(spriteCloud2);
		window.draw(spriteCloud3);
		for(int i = 0; i < NUM_BRANCHES; i++) {
			window.draw(branches[i]);
		}
		window.draw(spriteTree);
		window.draw(spriteBee);
		window.draw(scoreText);
		if(paused) window.draw(messageText);
		window.draw(timeBar);
		
		window.draw(spritePlayer);
		//window.draw(spriteRIP);
		window.draw(spriteAxe);
		window.draw(spriteLog);
		window.display();
		
	}
}

void updateBranches(int seed) {
	for(int j = NUM_BRANCHES-1; j > 0; j--) {
		branchPosition[j] = branchPosition[j-1];
	}
	srand((int)time(0) + seed);
	int r = (rand()%5);
	switch(r) {
		case 0:
			branchPosition[0] = side::LEFT;
			break;
		case 1:
			branchPosition[0] = side::RIGHT;
			break;
		default:
			branchPosition[0] = side::NONE;
	}
}