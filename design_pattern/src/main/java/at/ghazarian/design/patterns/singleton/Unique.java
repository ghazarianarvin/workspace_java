package at.ghazarian.design.patterns.singleton;

public class Unique {

    // why not instantiating object here? Because we want instance being instantiated, when it's accessed the first time.
    // if the first field/method access is the method printHello, the jvm would instantiate this field!
    private static volatile Unique instance = null;

    private Unique() {
        super();
        // super IO heaving operations following...
    }

    public static Unique getInstance() {
        if (instance == null) {
            synchronized (Unique.class) {
                if (instance == null) {
                    instance = new Unique();
                    // java memory model allows the publication of partially initialized objects, meaning
                    // 1. call super()
                    // 2. assign empty Unique object to instance
                    // 3. call Unique();
                    // solution --> volatile key word
                }
            }
        }
        return instance;
    }

    public static void printHello() {
        System.out.println("hello!");
    }
}
