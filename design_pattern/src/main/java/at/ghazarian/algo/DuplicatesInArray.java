package at.ghazarian.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DuplicatesInArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 7, 3, 8, 8, 9, 6, 5, 3, 9, 0, 7, 7};
        findDuplicatesUsingHashMap(array);
        findDuplicatesUsingBySorting(array);
    }

    private static void findDuplicatesUsingBySorting(int[] array) {
        Arrays.sort(array);
        Set<Integer> duplicates = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            // no need to check last element
            if ((i + 1) == array.length)
                break;
            if (array[i] == array[i + 1])
                duplicates.add(array[i]);
        }
        System.out.println(Arrays.toString(duplicates.toArray()));
    }

    private static void findDuplicatesUsingHashMap(int[] array) {
        HashMap<Integer, Integer> numberOccurances = new HashMap<>();
        Set<Integer> duplicates= new HashSet<>();
        for (int num : array) {
            if (numberOccurances.get(num) == null) {
                numberOccurances.put(num, 1);
            } else {
                int newOccurance = numberOccurances.get(num) + 1;
                numberOccurances.put(num, newOccurance);
                duplicates.add(num);
            }
        }
        System.out.println(Arrays.toString(duplicates.toArray()));
    }
}
