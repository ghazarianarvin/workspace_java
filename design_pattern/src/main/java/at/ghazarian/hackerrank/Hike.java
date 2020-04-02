package at.ghazarian.hackerrank;

public class Hike {

    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU"));
    }

    static int countingValleys(int n, String s) {
        int currentLevel = 0;
        int index = 0;
        int vallyCount = 0;
        while (index < n) {
            char hill = s.charAt(index);
            if (currentLevel == -1 && hill == 'U') {
                vallyCount++;
            }
            if (hill == 'U') {
                currentLevel ++;
            } else {
                currentLevel --;
            }
            index ++;
        }
        return vallyCount;
    }
}
