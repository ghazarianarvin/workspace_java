package at.ghazarian.data.structure;

import java.util.Objects;

public class SomeObject {

    private String name;
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeObject that = (SomeObject) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return "SomeObject{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int hashCode() {
        System.out.println("hasCode called");
        return Objects.hash(name, id);
    }

    public SomeObject(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
