#pragma once
#include <SFML/Graphics.hpp>
using namespace sf;

class Bat{
private:
	Vector2f m_Position;  //Holds the horizontal and the veritcal position of the player's bat.
	RectangleShape m_Shape; //Actual Bat that appears on the screen.
	float m_Speed = 1000.0f;
	bool m_MovingRight = false;
	bool m_MovingLeft = false;
	
public:
	Bat(float startX,float startY);
	FloatRect getPosition();
	RectangleShape getShape();
	
	void moveLeft();
	void moveRight();
		
	void stopLeft();
	void stopRight();
		
	void update(Time dt);	
};