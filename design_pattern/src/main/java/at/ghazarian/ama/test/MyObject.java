package at.ghazarian.ama.test;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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
