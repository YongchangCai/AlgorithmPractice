/*
 * Click `Run` to execute the snippet below!
 */


/*
Given two strings source and target, return the minimum window substring of source such that every character in target (including duplicates) is included in the window. If there is no such substring, return the empty string.
A substring is a contiguous sequence of characters within the string.

Example 1:
Input: source = "ADOBECODEBANC", target = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string target.


ADOBEC
left->A
right -> C

left-

Example 2:
Input: source = "a", target = "a"
Output: "a"
Explanation: The entire string source is the minimum window.

Example 3:
Input: source = "a", target = "aa"
Output: ""
Explanation: Both 'a's from target must be included in the window.
Since the largest window of source only has one 'a', return empty string.
*/


import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
//Hi I spent 5 more mins to fixed the bug, thanks for you time.

// Got it. Thanks.

class Solution {
    public static void main(String[] args) {

        System.out.println(findMinSubString("ADOBECODEBANC", "ABC"));
        System.out.println(findMinSubString("ADOBECODEBANC", "A"));
        System.out.println(findMinSubString("ADOBECODEBANC", "AC"));
        System.out.println(findMinSubString("ADOBECODEBANC", "AB"));
        System.out.println(findMinSubString("ADOBECODEBANC", "AA"));
    }

    //O(n^3) brut force

    //O(n^2) O(n)
    public static String findMinSubString(String source, String target) {
        if (Objects.isNull(source) || Objects.isNull(target)
                || source.length() == 0 || target.length() == 0) {
            return "";
        }

        Map<Character, Integer> requireChar = new HashMap<>();

        int counter = target.length();
        for (int i = 0; i < counter; i++) {
            char c = target.charAt(i);
            requireChar.put(c, requireChar.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minRight = source.length()+1;
        Map<Character, Integer> overflow = new HashMap<>();
        while (left < source.length()) {
            while (right < source.length() && counter > 0) {
                if (left > right) {
                    right = left;
                }
                char c = source.charAt(right++);
                if (requireChar.containsKey(c)) {
                    if (requireChar.get(c) == 0) {
                        overflow.put(c, overflow.getOrDefault(c, 0) + 1);
                    } else {
                        requireChar.put(c, requireChar.get(c) - 1);
                        counter--;
                    }
                }
            }

            if (counter == 0 && minRight - minLeft > right - left) {
                minLeft = left;
                minRight = right;
            }

            char left_c = source.charAt(left++);
            int over = overflow.getOrDefault(left_c, 0);
            if (requireChar.containsKey(left_c) && over == 0) {
                counter++;
                requireChar.put(left_c, requireChar.get(left_c) + 1);
            } else if (over != 0) {
                overflow.put(left_c, over-1);
            }
        }


        return minRight > source.length() ? "" : source.substring(minLeft, minRight);
    }

}
