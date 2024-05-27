package co.edu.uptc.model;

import java.awt.*;

public class Ball extends GameObject {
    public Game game;
    public int xVelocity;
    public int yVelocity;

    public Ball(int x, int y, int width, int height, Game game) {
        super();
        this.game = game;
        elementPojo.setX(x);
        elementPojo.setY(y);
        elementPojo.setWidth(width);
        elementPojo.setHeight(height);
        xVelocity = 1;
        yVelocity = 1;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void updatePosition() {
        elementPojo.setX(elementPojo.getX() - xVelocity);
        elementPojo.setY(elementPojo.getY() + yVelocity);
    }

    public void move(Rectangle borders, boolean collisionLeft, boolean collisionRight) {
        updatePosition();

        if (elementPojo.getY() <= borders.y || elementPojo.getY() + elementPojo.getHeight() >= borders.height) {
            yVelocity = -yVelocity;
        }

        if (elementPojo.getX() <= borders.x) {
            game.pointRight();
            elementPojo.setX(borders.width / 2);
            elementPojo.setY( borders.height / 2);
        } else if (elementPojo.getX() + elementPojo.getWidth() >= borders.width) {
            game.pointLeft();
            elementPojo.setX(borders.width / 2);
            elementPojo.setY( borders.height / 2);
        }

        if (collisionLeft) {
            xVelocity = -xVelocity;
            elementPojo.setX(20);
        }

        if (collisionRight) {
            xVelocity = -xVelocity;
            elementPojo.setX(745);
        }
    }

}
