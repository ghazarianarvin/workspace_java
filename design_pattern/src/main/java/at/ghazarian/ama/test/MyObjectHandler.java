package at.ghazarian.ama.test;

import java.util.*;
import java.util.function.Predicate;

public class MyObjectHandler {

    private static MyObjectHandler instance;

    private List<MyObject> myObjects;

    private MyObjectHandler() {
        this.myObjects = new ArrayList<>();
    }

    public static synchronized MyObjectHandler getInstance() {
        if (instance == null) {
            instance = new MyObjectHandler();
        }
        return instance;
    }

    public boolean addObject(int id, String name) {
        if (id < 0 || name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("wrong params");
        }
        if (!containsObjectWithId(id)) {
            myObjects.add(new MyObject(id, name));
            return true;
        }
        return false;
    }

    public MyObject getObjectId(int id) {
        return findObjectByPredicate(o -> o.getId() == id).orElse(null);
    }

    public MyObject getObjectName(String name) {
        return findObjectByPredicate(o -> o.getName().equals(name)).orElse(null);
    }

    public List<MyObject> getList() {
        return Collections.unmodifiableList(myObjects);
    }

    private boolean containsObjectWithId(int id) {
        return findObjectByPredicate(o -> o.getId() == id).isPresent();
    }

    private Optional<MyObject> findObjectByPredicate(Predicate<MyObject> predicate) {
        return myObjects.stream().filter(predicate).findFirst();
    }
}
