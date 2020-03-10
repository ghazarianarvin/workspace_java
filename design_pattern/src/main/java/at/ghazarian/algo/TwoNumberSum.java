package at.ghazarian.algo;

import java.util.Arrays;

public class TwoNumberSum {

    public static void main(String[] args) {
        int[] result = twoNumberSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 7);
        System.out.println(Arrays.toString(result));
        result = twoNumberSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 5);
        System.out.println(Arrays.toString(result));
        result = twoNumberSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 50);
        System.out.println(Arrays.toString(result));
        result = twoNumberSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 13);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (i == j)
                    continue;
                if (array[i] + array[j] == targetSum) {
                    return new int[] {array[i], array[j]};
                }
            }
        }
        return new int[] {};
    }
}
