package co.edu.uptc.model;

import co.edu.uptc.pojo.ElementPojo;

public class Racket extends ElementPojo {

    public Racket(int x, int y, int width, int height) {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
    }

    public void moveUp() {
        setY(getY() - 5);
    }

    public void moveDown() {
        setY(getY() + 5);
    }
}
