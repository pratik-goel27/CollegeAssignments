#include <SFML/Graphics.hpp>
#include "Bat.h"
#include "Ball.h"
#include <sstream>
using namespace sf;

int main(){
	VideoMode vm(1920,1080);
	RenderWindow window(vm,"Pong");
	View view(FloatRect(0, 0, 1920, 1080));
	window.setView(view);
	int score = 0;
	int lives = 3;

	// Create a Bat :-
	Bat bat(1920/2,1080-20);

	//Create a Ball :-
	Ball ball(1920/2, 0);
	
	Text hud;
	Font font;
	font.loadFromFile("KOMIKAP_.ttf");
	hud.setFont(font);
	hud.setCharacterSize(75);
	hud.setFillColor(Color::White);
	hud.setPosition(20,20);
	
	Clock clock;
	
	while (window.isOpen()) { 
		/* Handle the player input :- */
		Event event;
		while (window.pollEvent(event)) {
			if (event.type == Event::Closed) {
				window.close();
			}
		}
		// Handle the player quitting :-
		if (Keyboard::isKeyPressed(Keyboard::Escape)) {
			window.close();
		}
		
		// Handle the pressing and releasing of the arrow :-
		if(Keyboard::isKeyPressed(Keyboard::Left)){
			bat.moveLeft();
		}else{
			bat.stopLeft();
		}
		
		if(Keyboard::isKeyPressed(Keyboard::Right)){
			bat.moveRight();
		}else{
			bat.stopRight();
		}
		


		/* Update the bat, ball and HUD */
		// Update the delta time :-
		Time dt = clock.restart();
		bat.update(dt);
		ball.update(dt);

		// Update the HUD text :-
		std::stringstream ss;
		ss << "score:" << score << " Lives:" << lives;
		hud.setString(ss.str());

		// Handle ball hitting the bottom :-
		if (ball.getPosition().top > window.getSize().y) {
			ball.reboundBottom();
			lives--;
			if (lives < 1) {
				score = 0;
				lives = 3;
			}
		}

		// Handle ball hitting top
		if (ball.getPosition().top < 0) {
			ball.reboundBatOrTop();
			// Add a point to the players score
			score++;
		}
		
		// Handle ball hitting sides
		if (ball.getPosition().left < 0 || ball.getPosition().left + ball.getPosition().width > window.getSize().x) {
			ball.reboundSides();
		}

		// Has the ball hit the bat?
		if (ball.getPosition().intersects(bat.getPosition())) 	{
			// Hit detected so reverse the ball and score a point.
			ball.reboundBatOrTop();
		}



		/*Draw the bat, the ball and the HUD*/
		window.clear();
		window.draw(hud);
		window.draw(bat.getShape());
		window.draw(ball.getShape());
		window.display();
	}
	return 0;
}