///**
// * Given a string s, return the longest palindromic substring in s.
// * <p>
// * <p>
// * <p>
// * Example 1:
// * <p>
// * Input: s = "babad"
// * Output: "bab"
// * Note: "aba" is also a valid answer.
// * Example 2:
// * <p>
// * Input: s = "cbbd"
// * Output: "bb"
// * Example 3:
// * <p>
// * Input: s = "a"
// * Output: "a"
// * Example 4:
// * <p>
// * Input: s = "ac"
// * Output: "a"
// * <p>
// * <p>
// * Constraints:
// * <p>
// * 1 <= s.length <= 1000
// * s consist of only digits and English letters (lower-case and/or upper-case),
// */
//public class LongestPalindromicSubstring {
//    public String longestPalindrome(String s) {
//        int longestLength;
//        int longStart;
//
//        for (int i = 0; i < s.length(); i++) {
//            int odd = expendPalindromic(s, i, i);
//            int even = expendPalindromic(s, i, i+1);
//
//        }
//    }
//
//    private int expendPalindromic(String s, int start, int end) {
//        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
//            start--;
//            end++;
//        }
//        return end - start + 1;
//    }
//}
