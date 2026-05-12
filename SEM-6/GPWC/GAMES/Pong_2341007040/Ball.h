#pragma once
#include <SFML/Graphics.hpp>
using namespace sf;

class Ball {
private:
    Vector2f m_Position;
    RectangleShape m_Shape;
    float m_Speed = 1500.0f;
    float m_DirectionX = .2f;
    float m_DirectionY = .2f;

public:
    Ball(float startX, float startY);
    FloatRect getPosition();
    RectangleShape getShape(); 
    float getXVelocity();
    void reboundSides(); //When the ball hits the either sides of the screen.
    void reboundBatOrTop(); //When the ball either hits the top or the bat.
    void reboundBottom(); //When the ball hits the bottom of the screen.
    void update(Time dt);
};