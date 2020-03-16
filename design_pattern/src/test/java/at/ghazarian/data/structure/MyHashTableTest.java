package at.ghazarian.data.structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

class MyHashTableTest {

    MyHashTable<String, Integer> ht;


    @BeforeEach
    public void setup() {
        ht = new MyHashTable<>();
        ht.put("ONE", 1);
        ht.put("TWO", 2);
        ht.put("THREE", 3);
        ht.put("FOUR", 4);
        ht.put("FIVE", 5);
    }

    @Test
    void testPutDuplicate() {
        var oldValue = ht.put("ONE", 10);
        Assertions.assertNotNull(oldValue);
        Assertions.assertEquals(1, oldValue.intValue());
    }

    @Test
    void testGet() {
        Assertions.assertEquals(1, ht.get("ONE").intValue());
        Assertions.assertEquals(2, ht.get("TWO").intValue());
        Assertions.assertEquals(3, ht.get("THREE").intValue());
        Assertions.assertEquals(4, ht.get("FOUR").intValue());
    }

    @Test
    void testNotFound() {
        Assertions.assertNull(ht.get("XX"));
    }

}