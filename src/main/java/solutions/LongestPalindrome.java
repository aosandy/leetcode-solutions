package solutions;

import java.util.*;

/**
 * 409. Longest Palindrome
 */

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        Collection<Character> chars = map.keySet();
        int res = 0;
        int mid = 0;
        for (char ch : chars) {
            if (map.get(ch) % 2 == 1) {
                mid = 1;
                map.put(ch, map.get(ch) - 1);
                break;
            }
        }
        for (char ch : chars) {
            res += map.get(ch) / 2;
        }

        return res * 2 + mid;
    }

    // Better solution
    public static int longestPalindrome_2(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
                res += 2;
            } else {
                set.add(ch);
            }
        }
        if (!set.isEmpty()) {
            res++;
        }
        return res;
    }
}
