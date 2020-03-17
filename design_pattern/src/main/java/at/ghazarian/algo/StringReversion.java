package at.ghazarian.algo;

public class StringReversion {

    public static void main(String[] args) {
        String reversed = reverseUsingLoop("Reverse_me");
        System.out.println(reversed);
        reversed = reverseUsingRecursion("Reverse_me", 0);
        System.out.println(reversed);
        reversed = reverseUsingRecursionSubstring("Reverse_me");
        System.out.println(reversed);
    }

    private static String reverseUsingRecursionSubstring(String reverse_me) {
        if (reverse_me == null || reverse_me.isEmpty() || reverse_me.length() == 0)
            return reverse_me;
        return reverseUsingRecursionSubstring(reverse_me.substring(1)) + reverse_me.charAt(0);
    }

    private static String reverseUsingRecursion(String reverse_me, int currentIndex) {
        if (reverse_me.length() == currentIndex)
            return "";
        return reverseUsingRecursion(reverse_me,  (currentIndex + 1)) + reverse_me.charAt(currentIndex);
    }


    private static String reverseUsingLoop(String reverse_me) {
        String result = "";
        for (int i = reverse_me.length() - 1; i >= 0; i--)
            result += reverse_me.charAt(i);
        return result;
    }
}
