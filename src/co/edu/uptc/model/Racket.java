package co.edu.uptc.model;

import co.edu.uptc.pojo.ElementPojo;
import co.edu.uptc.view.KeyboardEvent;

import java.awt.*;

public class Racket extends GameObject {

    public Racket(int x, int y, int width, int height) {
       elementPojo.setX(x);
       elementPojo.setY(y);
       elementPojo.setWidth(width);
       elementPojo.setHeight(height);
       speed = 1;
    }

    public void moveRacketLeft(Rectangle bounds) {
        if (KeyboardEvent.w && elementPojo.getY() > bounds.getMinY()) {
            elementPojo.setY(elementPojo.getY()-1);
        }
        if (KeyboardEvent.s && elementPojo.getY() < bounds.getMaxY()-elementPojo.getHeight()) {
            elementPojo.setY(elementPojo.getY()+1);
        }
    }

    public void moveRacketRight(Rectangle bounds) {
        if (KeyboardEvent.up && elementPojo.getY() > bounds.getMinY()) {
            elementPojo.setY(elementPojo.getY()-1);
        }
        if (KeyboardEvent.down && elementPojo.getY() < bounds.getMaxY()-elementPojo.getHeight()) {
            elementPojo.setY(elementPojo.getY()+1);
        }
    }
}
