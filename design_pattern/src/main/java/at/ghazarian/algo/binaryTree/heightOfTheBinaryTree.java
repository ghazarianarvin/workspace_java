package at.ghazarian.algo.binaryTree;

public class heightOfTheBinaryTree {

    static class Node {

        public Node(int value) {
            this.value = value;
        }

        int value;
        Node left;
        Node right;
    }

    public static int heightOfBTreeRecursion(Node root, int height) {
        if (root == null) {
            return height;
        }
        height ++;
        return heightOfBTreeRecursion(root.left, height);
    }

    public static void main(String[] args) {

    }
}
