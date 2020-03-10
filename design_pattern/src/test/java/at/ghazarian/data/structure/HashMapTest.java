package at.ghazarian.data.structure;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class HashMapTest {

    private static HashMap<SomeObject, String> myHashMap = new HashMap<>();

    @BeforeAll
    public static void setup() {
        myHashMap.put(new SomeObject("blubb", (int) (Math.random() * 100)), "blub");
        myHashMap.put(new SomeObject("xxx", (int) (Math.random() * 100)), "xxx");
        myHashMap.put(new SomeObject("nn", (int) (Math.random() * 100)), "mmm");
    }

    @Test
    public void test() {
        myHashMap.entrySet().forEach(entrySet -> {
            System.out.println(entrySet.getClass());
            System.out.println(entrySet.toString());
        });
    }
}
