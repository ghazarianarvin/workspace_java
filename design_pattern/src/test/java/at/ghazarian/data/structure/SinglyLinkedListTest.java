package at.ghazarian.data.structure;

import org.junit.jupiter.api.*;

import java.util.Iterator;

class SinglyLinkedListTest {

    private SinglyLinkedList<String> list;

    @BeforeEach
    public void setup() {
        list = new SinglyLinkedList<>();
        list.insert("blub");
        list.insert("foo");
        list.insert("bar");
        list.insert("uhu");
        list.insert("hi");
    }

    @Test
    public void printListTest() {
        list.printList();
        System.out.println("---------------------------------");
    }

    @Test
    public void printListEmptyTest() {
        list.deleteAll();
        list.printList();
    }

    @Test
    public void testDeleteNonExisting() {
        boolean deleted = list.deleteObject("XXXXX");
        Assertions.assertFalse(deleted);
        Assertions.assertEquals(5, list.size());
    }

    @Test
    public void testDeleteElementMiddle() {
        boolean deleted = list.deleteObject("bar");
        Assertions.assertTrue(deleted);
        Assertions.assertEquals(4, list.size());
        list.printList();
        System.out.println("---------------------------------");
    }

    @Test
    public void testDeleteLastElement() {
        boolean deleted = list.deleteObject("hi");
        Assertions.assertTrue(deleted);
        Assertions.assertEquals(4, list.size());
        list.printList();
        System.out.println("---------------------------------");
    }

    @Test
    public void testDeleteFirstElement() {
        boolean deleted = list.deleteObject("blub");
        Assertions.assertTrue(deleted);
        Assertions.assertEquals(4, list.size());
        list.printList();
        System.out.println("---------------------------------");
    }

    @Test
    public void testDeleteNull() {
        boolean deleted = list.deleteObject(null);
        Assertions.assertFalse(deleted);
    }

    @Test
    public void testDeleteAt() {
        String deletedObject = list.deleteObjectAt(0);
        Assertions.assertNotNull(deletedObject);
        Assertions.assertEquals("blub", deletedObject);
        Assertions.assertEquals(4, list.size());
    }

    @Test
    public void testDeleteAtTwoMiddleElements() {
        String deletedObject = list.deleteObjectAt(2);
        String deletedObjectTwo = list.deleteObjectAt(3);
        Assertions.assertNotNull(deletedObject);
        Assertions.assertNotNull(deletedObjectTwo);
        Assertions.assertEquals("bar", deletedObject);
        Assertions.assertEquals("hi", deletedObjectTwo);
        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void testDeleteAtIndexOutOfBoundException() {
        Assertions.assertAll(
                () -> Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.deleteObjectAt(-2)),
                () -> Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.deleteObjectAt(list.size()))
        );
    }

    @Test
    public void testGet() {
        String first = list.get(0); // blub
        String last = list.get(list.size() - 1); // hi
        String middle = list.get(3); //uhu
        Assertions.assertEquals("blub", first);
        Assertions.assertEquals("hi", last);
        Assertions.assertEquals("uhu", middle);
        Assertions.assertAll(
                () -> Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1)),
                () -> Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()))
        );
    }


}