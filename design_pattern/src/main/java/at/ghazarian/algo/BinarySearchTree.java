package at.ghazarian.algo;

/**
 *
 */
public class BinarySearchTree {

    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBst(tree, tree, target);
    }

    private static int findClosestValueInBst(BST currentNode, BST closestNode, int target) {
        if (target > currentNode.value) {
            if (currentNode.right == null) {
                return closestNode.value;
            }
            closestNode = determineClosest(currentNode.right, closestNode, target);
            return findClosestValueInBst(currentNode.right, closestNode, target);
        } else if (target < currentNode.value) {
            if (currentNode.left == null) {
                return closestNode.value;
            }
            closestNode = determineClosest(currentNode.left, closestNode, target);
            return findClosestValueInBst(currentNode.left, closestNode, target);
        }
        return closestNode.value;
    }

    private static BST determineClosest(BST child, BST closestNode, int target) {
        if (Math.abs(child.value - target) < Math.abs(closestNode.value - target))
            return child;
        return closestNode;
    }


    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
