#include <SFML/Graphics.hpp>
#include "Bat.h"
#include <sstream>
using namespace sf;

int main(){
	VideoMode vm(1920,1080);
	RenderWindow window(vm,"Pong");
	View view(FloatRect(0, 0, 1920, 1080));
	window.setView(view);
	int score = 0;
	int life = 3;
	Bat bat(1920/2,1080-20);
	
	Text hud;
	
	Font font;
	font.loadFromFile("KOMIKAP_.ttf");
	hud.setFont(font);
	hud.setCharacterSize(75);
	hud.setFillColor(Color::White);
	hud.setPosition(20,20);
	
	Clock clock;
	
	
	while (window.isOpen()) {
		Event event;
		while (window.pollEvent(event)) {
			if (event.type == Event::Closed) {
				window.close();
			}
		}
		if (Keyboard::isKeyPressed(Keyboard::Escape)) {
			window.close();
		}
		
		// Handle Player Input
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
		
		Time dt = clock.restart();
		bat.update(dt);
		std::stringstream ss;
		ss << "score:" << score << " Lives:" << life;
		hud.setString(ss.str());
		
		// Update the bat, ball and HUD
		
		
		
		// Draw all
		window.clear();
		window.draw(hud);
		window.draw(bat.getShape());
		window.display();
	}
	
	return 0;
}