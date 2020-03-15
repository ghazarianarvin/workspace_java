package at.ghazarian.algo.sort;

import java.util.Arrays;

public class BubleSort {

    public static void main(String[] args) {
        int[] array = {12, 22, 67, 98, 3, 6, 4, 9, 1001, 8, -22, -8, 99, -154};
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
