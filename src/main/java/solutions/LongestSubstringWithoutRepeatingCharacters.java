package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring("pwwkew");
        System.out.println(ans);
    }

    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Set<Character> charSet = new HashSet<>();

        char[] arr = s.toCharArray();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = arr[r];
            while (charSet.contains(ch)) {
                charSet.remove(arr[l]);
                l++;
            }
            int currentAns = r - l + 1;
            if (currentAns > ans) {
                ans = currentAns;
            }
            charSet.add(ch);
        }
        return ans;
    }
}
