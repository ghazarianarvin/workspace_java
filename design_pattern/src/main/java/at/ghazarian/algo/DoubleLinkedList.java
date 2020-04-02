package at.ghazarian.algo;

public class DoubleLinkedList {

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if (this.head != null)
                insertBefore(head, node);
            this.head = node;
        }

        public void setTail(Node node) {
            if (this.tail != null)
                insertAfter(tail, node);
            this.tail = node;
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            if (node.prev != null) {
                Node temp = node.prev;
                nodeToInsert.prev = temp;
            }
            nodeToInsert.next = node;
            node.prev = nodeToInsert;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            if (node.next != null) {
                Node temp = node.next;
                nodeToInsert.next = temp;
            }
            node.next = nodeToInsert;
            nodeToInsert.prev = node;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            Node currentNode = head;
            while (position > 1 && currentNode != null) {
                currentNode = currentNode.next;
                position--;
            }
            if (currentNode == head) {
                setHead(nodeToInsert);
            } else if (currentNode == tail) {
                setTail(nodeToInsert);
            } else {
                insertBefore(currentNode, nodeToInsert);
            }
        }

        public void removeNodesWithValue(int value) {
            Node currentNode = head;
            while (currentNode != null) {
                if (currentNode.value == value)
                    remove(currentNode);
                currentNode = currentNode.next;
            }
        }

        public void remove(Node node) {
            if (node == null)
                return;

            if (node == head) {
                head = head.next;
                head.prev = null;
                return;
            }

            if (node == tail) {
                tail = tail.prev;
                tail.next = null;
                return;
            }

            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;

        }

        public boolean containsNodeWithValue(int value) {
            Node currentNode = head;
            while (currentNode != null) {
                if (currentNode.value == value)
                    return true;
                currentNode = currentNode.next;
            }
            return false;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
