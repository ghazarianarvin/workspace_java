package at.ghazarian.ama.bad;

import at.ghazarian.ama.test.MyObject;
import at.ghazarian.ama.test.MyObjectHandler;

public class BadClass {

    public static void main(String[] args) {
        // MyObject o = new MyObject(); <-- compile error
        MyObjectHandler myObjectHandler = MyObjectHandler.getInstance();
        System.out.println(myObjectHandler.addObject(1, "aa"));
        System.out.println(myObjectHandler.addObject(2, "bb"));
        System.out.println(myObjectHandler.addObject(2, "cc"));

        System.out.println(myObjectHandler.getObjectId(1));
        System.out.println(myObjectHandler.getObjectId(2));

        System.out.println(myObjectHandler.getObjectName("aa"));
        System.out.println(myObjectHandler.getObjectName("bb"));
        System.out.println(myObjectHandler.getObjectName("cc"));

        myObjectHandler.getList().removeIf(o -> o.getId() == 1);
    }
}
