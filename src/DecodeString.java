import javax.xml.stream.events.Characters;
import java.util.Deque;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class DecodeString {

    /**
     * Given an encoded string, return its decoded string.
     *
     * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
     *
     * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
     *
     * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers,
     * k. For example, there won't be input like 3a or 2[4].
     * @param s
     * @return
     */
    public String decodeString(String s) {
        String result = "";
        if (Objects.isNull(s) || s.length() == 0) {
            return result;
        }

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int temp_count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                temp_count = 10 * temp_count + c - '0';
            } else if (c == '[') {
                countStack.push(temp_count);
                stringStack.push(result);
                result = "";
                temp_count = 0;
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                sb.append(stringStack.pop());
                for (int j = countStack.pop(); j > 0; j--) {
                    sb.append(result);
                }
                result = sb.toString();
            } else {
                result += c;
            }
        }

        return result;
    }
}
