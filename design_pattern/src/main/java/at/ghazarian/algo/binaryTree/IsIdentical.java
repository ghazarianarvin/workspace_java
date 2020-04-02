package at.ghazarian.algo.binaryTree;

import org.junit.jupiter.api.Assertions;

public class IsIdentical {

    static class Node {

        public Node(int value) {
            this.value = value;
        }

        int value;
        Node left;
        Node right;
    }

    public static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (!(root1 != null && root2 != null)) {
            return false;
        }
        boolean valuesIdentical = root1.value == root2.value;
        boolean leftIdentical = isIdentical(root1.left, root2.left);
        boolean rightIdentical = isIdentical(root1.right, root2.right);

        return leftIdentical && rightIdentical && valuesIdentical;
    }

    public static void main(String[] args) {
        Node x = new Node(15);
        x.left = new Node(10);
        x.right = new Node(20);
        x.left.left = new Node(8);
        x.left.right = new Node(12);
        x.right.left = new Node(16);
        x.right.right = new Node(25);

        // construct second tree
        Node y = new Node(15);
        y.left = new Node(10);
        y.right = new Node(20);
        y.left.left = new Node(8);
        y.left.right = new Node(12);
        y.right.left = new Node(16);
        y.right.right = new Node(25);

        if (isIdentical(x, y)) {
            System.out.print("Given binary Trees are identical");
        } else {
            System.out.print("Given binary Trees are not identical");
        }
    }
}
