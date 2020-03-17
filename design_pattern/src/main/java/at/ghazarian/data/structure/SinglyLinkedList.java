package at.ghazarian.data.structure;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private int size = 0;

    private class Node<T> {
        T data;
        Node<T> next;
    }

    public void insert(T item) {
        Node<T> newNode = new Node<>();
        newNode.data = item;

        if (head == null) {
            head = newNode;
        } else {
            Node<T> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }

        size++;
    }

    public void printList() {
        if (head == null)
            return;
        Node<T> currentNode = head;
        do {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        } while (currentNode != null);
    }

    public boolean deleteObject(T object) {
        if (object == null || head == null)
            return false;
        Node<T> currentNode = head;
        Node<T> prevNode = null;
        do {
            if (object.equals(currentNode.data)) {
                // delete head
                if (prevNode == null) {
                    head = head.next;
                } else {
                    prevNode.next = currentNode.next;
                }
                size--;
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        } while (currentNode != null);
        return false;
    }

    public T deleteObjectAt(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index must be between 0 and " + (size - 1));
        if (index == 0) {
            T headData = head.data;
            head = head.next;
            size--;
            return headData;
        }
        Node<T> nodeAtIndex = head;
        Node<T> prevNode = null;
        while (index > 0) {
            prevNode = nodeAtIndex;
            nodeAtIndex = nodeAtIndex.next;
            index--;
        }
        T nodeData = nodeAtIndex.data;
        prevNode.next = nodeAtIndex.next;
        size--;
        return nodeData;
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index must be between 0 and " + (size - 1));
        Node<T> nodeAtIndex = head;
        while (index > 0) {
            nodeAtIndex = nodeAtIndex.next;
            index--;
        }
        return nodeAtIndex.data;
    }

    public void deleteAll() {
        head = null;
        size = 0;
    }

    /**
     * find the middle element of a linked list in one trip
     * @return
     */
    public T middleElement() {
        if (head == null)
            return null;

        boolean skip = true;
        var middleElement = head;
        var currentNode = head;

        while (currentNode != null) {
            if (!skip) {
                middleElement = middleElement.next;
            }
            currentNode = currentNode.next;
            skip = !skip || (currentNode != null && currentNode.next == null);
        }
        return middleElement.data;
    }

    /**
     * find the k-th element from the end in one pass
     * not using size
     * @return
     */
    public T kElementFromTheTail(int k) {
        if (k == 1 && head.next == null)
            return head.data;

        int listSize = 0;
        Node<T> currentNode = head;
        while (currentNode != null) {
            listSize ++;
            currentNode = currentNode.next;
        }

        if (k > size) {
            throw new IllegalArgumentException("k must be between one and " + size);
        }

        currentNode = head;
        for (int i = 0; i < (listSize - k); i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    public int size() {
        return size;
    }
}
