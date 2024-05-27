package co.edu.uptc.model;

import co.edu.uptc.pojo.ElementPojo;

public class Racket extends GameObject {

    public Racket(int x, int y, int width, int height) {
       elementPojo.setX(x);
       elementPojo.setY(y);
       elementPojo.setWidth(width);
       elementPojo.setHeight(height);
    }

    public void moveUp() {
        elementPojo.setY(elementPojo.getY() + speed);
    }

    public void moveDown() {
        elementPojo.setY(elementPojo.getY() - speed);
    }
}
