package at.ghazarian.data.structure;

import java.util.EmptyStackException;

public class Stack<T> {

    private Element<T> topElement;
    private int size;

    public boolean empty() {
        return topElement == null;
    }

    public T peek() {
        return topElement == null ? null : topElement.data;
    }

    public T pop() {
        if (topElement != null) {
            T data = topElement.data;
            topElement = topElement.prevElement;
            size --;
            return data;
        }
        throw new EmptyStackException();
    }

    public void push(T data) {
        Element<T> element = new Element<>();
        element.data = data;
        if (topElement != null) {
            element.prevElement = topElement;
        }
        topElement = element;
        size ++;
    }

    public int search(T object) {
        if (object == null)
            throw new IllegalArgumentException();
        int index = 0;
        Element<T> currentElement = topElement;
        while (true) {
            if (currentElement == null)
                return -1;
            if (object.equals(currentElement.data)) {
                return index;
            }
            currentElement = currentElement.prevElement;
            index++;
        }
    }

    public void deleteAll() {
        topElement = null;
    }

    public int size() {
        return size;
    }

    private class Element<T> {
        Element prevElement;
        T data;
    }
}
