package at.ghazarian.algo;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] toBeSearched = {8, 77, 56, 22, 34, 56, 72, 96, 35, 4, 6, 1, 5, 5, 9, 34, 69, 48, 12, 35};
        Arrays.sort(toBeSearched);
        System.out.println(Arrays.toString(toBeSearched) + " " + toBeSearched.length);
        System.out.println(bSearch(toBeSearched, 6));
        System.out.println(bSearch(toBeSearched, 35));
        System.out.println(bSearch(toBeSearched, 2));
        System.out.println(bSearch(toBeSearched, 77));
        System.out.println(bSearch(toBeSearched, 1));
        System.out.println(bSearch(toBeSearched, 96));
    }

    private static int bSearch(int[] toBeSearched, int searchValue) {
        return bSearch(toBeSearched, searchValue, 0, toBeSearched.length - 1);
    }

    public static int bSearch(int[] array, int forValue, int beginIndex, int endIndex) {
        if (beginIndex == endIndex) {
            if (array[beginIndex] == forValue)
                return beginIndex;
            return -1;
        }
        int middleIndex = (endIndex + beginIndex + 1) / 2;
        int currentValue = array[middleIndex];
        if (currentValue == forValue) {
            return middleIndex;
        } else if (currentValue > forValue) {
            // search lower half
            return bSearch(array, forValue, beginIndex, middleIndex - 1);
        } else if (currentValue < forValue){
            // search upper half
            return bSearch(array, forValue, middleIndex + 1, endIndex);
        } else {
            return -1;
        }
    }
}
