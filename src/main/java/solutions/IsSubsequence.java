package solutions;

/**
 * 1480. Running Sum of 1d Array
 */

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int i1 = 0;
        int length = s.length();
        for (int i2 = 0; i2 < t.length(); i2++) {
            if (s.charAt(i1) == t.charAt(i2)) {
                i1++;
            }
            if (i1 == length) {
                return true;
            }
        }
        return false;
    }
}
