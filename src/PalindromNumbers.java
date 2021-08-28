public class PalindromNumbers {
    /**
     * Given an integer x, return true if x is palindrome integer.
     *
     * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
     */

    public boolean isPalindrome(int x) {
        String input = Integer.toString(x);
        int i = 0;
        int j = input.length() - 1;
        boolean result = true;
        while (j > i) {
            if (input.charAt(i) != input.charAt(j)) {
                result = false;
                break;
            }
            i++;
            j--;
        }
        return result;
    }
}
