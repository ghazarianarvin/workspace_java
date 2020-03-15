package at.ghazarian.data.structure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
    }

    @AfterEach
    void tearDown() {
        stack = null;
    }

    @Test
    void empty() {
        Assertions.assertFalse(stack.empty());
        stack.deleteAll();
        Assertions.assertTrue(stack.empty());
    }

    @Test
    void peek() {
        Assertions.assertEquals("D", stack.peek());
    }

    @Test
    void pop() {
        String elementD = stack.pop();
        String elementC = stack.pop();
        Assertions.assertEquals("D", elementD);
        Assertions.assertEquals("C", elementC);
        Assertions.assertEquals("B", stack.peek());
        Assertions.assertEquals(2, stack.size());
        stack.deleteAll();
        Assertions.assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    void push() {
        stack.push("XX");
        Assertions.assertEquals("XX", stack.peek());
        Assertions.assertEquals(5, stack.size());
    }

    @Test
    void search() {
        Assertions.assertEquals(3, stack.search("A"));
        Assertions.assertEquals(2, stack.search("B"));
        Assertions.assertEquals(1, stack.search("C"));
        Assertions.assertEquals(0, stack.search("D"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stack.search(null));
    }
}