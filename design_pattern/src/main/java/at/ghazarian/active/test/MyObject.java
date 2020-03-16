package at.ghazarian.active.test;

import lombok.Getter;

@Getter
public class MyObject {

    private int id;
    private String name;

    private MyObject() {}

    protected MyObject(int id, String name) {
        this();
        this.id = id;
        this.name = name;
    }
}
