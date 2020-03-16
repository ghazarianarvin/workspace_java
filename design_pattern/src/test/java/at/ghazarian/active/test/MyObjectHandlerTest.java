package at.ghazarian.active.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyObjectHandlerTest {
    private static MyObjectHandler myObjectHandler = MyObjectHandler.getInstance();

    @BeforeAll
    public static void setup() {
        myObjectHandler.addObject(1, "object 1");
        myObjectHandler.addObject(2, "object 2");
        myObjectHandler.addObject(3, "object 3");
    }

    @Test
    public void testDuplicate() {
        boolean added = myObjectHandler.addObject(1, "duplicate object 1");
        assertFalse(added);
    }

    @Test
    public void testAddNew() {
        boolean added = myObjectHandler.addObject(44, "new object");
        assertTrue(added);
    }

    @Test
    public void testAddWrongParams() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> myObjectHandler.addObject(-1, "some name")),
                () -> assertThrows(IllegalArgumentException.class, () -> myObjectHandler.addObject(55, null)),
                () -> assertThrows(IllegalArgumentException.class, () -> myObjectHandler.addObject(66, "      "))
        );
    }

    @Test
    public void testGetObjectById() {
        assertAll(
                () -> assertTrue(myObjectHandler.getObjectId(1) != null),
                () -> assertEquals("object 1", myObjectHandler.getObjectId(1).getName()),
                () -> assertEquals(1, myObjectHandler.getObjectId(1).getId()),
                () -> assertTrue(myObjectHandler.getObjectId(33) == null)
        );
    }

    @Test
    public void testGetObjectByName() {
        assertAll(
                () -> assertTrue(myObjectHandler.getObjectName("object 1") != null),
                () -> assertTrue(myObjectHandler.getObjectName("object 2") != null),
                () -> assertTrue(myObjectHandler.getObjectName("xxxxx") == null)
        );
    }

    @Test
    public void testListUnmodifiable() {
        assertAll(
                () -> assertThrows(UnsupportedOperationException.class, () -> myObjectHandler.getList().remove(myObjectHandler.getObjectId(1))),
                () -> assertThrows(UnsupportedOperationException.class, () -> myObjectHandler.getList().add(null))
        );
    }

}
