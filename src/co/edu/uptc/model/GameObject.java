package co.edu.uptc.model;

import co.edu.uptc.pojo.ElementPojo;

public abstract class GameObject {
    protected ElementPojo elementPojo;
    protected int speed;

    public GameObject(){
        elementPojo = new ElementPojo();
    }

    public ElementPojo getElementPojo() {
        return elementPojo;
    }
}
