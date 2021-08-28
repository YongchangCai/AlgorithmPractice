import java.util.Stack;

public class Calculator {

    /**
     * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
     *
     * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
     */
    public int calculate(String s) {
        int result = 0;
        int index = 0;

        Stack<Integer> numStack = new Stack<>();

        Stack<Integer> plusStack = new Stack<>();

        s.split(" ");
        int v = 1;
        while (index < s.length()) {
            char currentChar = s.charAt(index++);
            if (Character.isDigit(currentChar)) {
                int value = currentChar - '0';
                while(index < s.length() && Character.isDigit(s.charAt(index))) {
                    value = value * 10 + (s.charAt(index) - '0');
                    index++;
                }
                result += (v * value);
                v = 1;
            } else if (currentChar == '(') {
                plusStack.add(v);
                numStack.add(result);
                result = 0;
                v = 1;
            } else if (currentChar == ')') {
                result = numStack.pop() + (result *plusStack.pop());
            } else if (currentChar == '+') {
                v = 1;
            } else if (currentChar == '-') {
                v = -1;
            }
        }

        return result;
    }
}
