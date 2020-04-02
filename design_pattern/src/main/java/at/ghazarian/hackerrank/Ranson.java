package at.ghazarian.hackerrank;

import java.util.HashMap;

public class Ranson {

    public static void main(String[] args) {

    }

    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> words = new HashMap<>();
        for (String s: magazine) {
            if (words.containsKey(s)) {
                int count = words.get(s) + 1;
                words.put(s, count);
                continue;
            }
            words.put(s,1);
        }
        for (String s: note) {
            if (!words.containsKey(s) || words.get(s) == 0) {
                System.out.println("No");
                return;
            }
            int count = words.get(s) -1;
            words.put(s, count);
        }
        System.out.println("Yes");
    }
}
