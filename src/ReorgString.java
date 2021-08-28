import java.util.Objects;

public class ReorgString {
    /**
     * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
     *
     * Return any possible rearrangement of s or return "" if not possible.
     */

    public String reorganizeString(String s) {
        String result = "";
        if (Objects.isNull(s) || s.length() == 0) {
            return result;
        }

        int[] charCount = new int[26];

        int max = 0;
        int max_char = -1;
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (max < charCount[i]) {
                max = charCount[i];
                max_char = i;
            }
        }

        if (max > s.length()/2 + s.length()%2) {
            return result;
        }

        char[] resultArray = new char[s.length()];
        int index = 0;
        while(charCount[max_char] > 0) {
            resultArray[index] = (char) ('a' + max_char);
            index += 2;
            charCount[max_char]--;
        }

        for (int i = 0; i < 26; i++) {
            while (charCount[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                resultArray[index] = (char) ('a' + i);
                charCount[i]--;
            }
        }

        return new String(resultArray);
    }
}
