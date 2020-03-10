package at.ghazarian.algo;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeBranchSum {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> result = new ArrayList<>();
        branchSums(root, 0, result);
        return result;
    }

    public static void branchSums(BinaryTree node, int currentSum, List<Integer> result) {
        if (node.left == null && node.right == null) {
            currentSum += node.value;
            result.add(currentSum);
        } else {
            if (node.left != null) {
                branchSums(node.left, currentSum + node.value, result);
            }
            if (node.right != null) {
                branchSums(node.right, currentSum + node.value, result);
            }
        }
    }
}
