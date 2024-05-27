package co.edu.uptc.model;

import java.awt.*;

public class Ball extends GameObject {
    public int xVelocity;
    public int yVelocity;

    public Ball(int x, int y, int width, int height) {
        super();
        elementPojo.setX(x);
        elementPojo.setY(y);
        elementPojo.setWidth(width);
        elementPojo.setHeight(height);
        xVelocity = 1;
        yVelocity = 1;
    }

    public void updatePosition() {
        elementPojo.setX(elementPojo.getX() + xVelocity);
        elementPojo.setY(elementPojo.getY() + yVelocity);
    }

    public void move(Rectangle bounds, boolean collisionLeft, boolean collisionRight) {
        updatePosition();

        if (elementPojo.getX() <= bounds.x || elementPojo.getX() + elementPojo.getWidth() >= bounds.width) {
            xVelocity = -xVelocity;
        }

        if (elementPojo.getY() <= bounds.y || elementPojo.getY() + elementPojo.getHeight() >= bounds.height) {
            yVelocity = -yVelocity;
        }

        if (collisionLeft || collisionRight) {
            xVelocity = -xVelocity;
        }
    }




}
