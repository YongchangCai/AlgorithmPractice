//import java.util.Objects;
//
//public class ReverseString {
//    /**
//     * Write a function that reverses a string. The input string is given as an array of characters s.
//     */
//    public void reverseString(char[] s) {
//        if (Objects.nonNull(s) && s.length > 1) {
//            int i = 0;
//            int j = s.length - 1;
//            while (i < j) {
//                char temp = s[i];
//                s[i] = s[j];
//                s[j] = temp;
//                i++;
//                j--;
//            }
//        }
//    }
//
//    public void reverseString (String s) {
//        if (Objects.nonNull(s) && s.length() > 1) {
//            for (int i=0;i < s.length()/2;i++) {
//                char temp = s.charAt(i);
//                s.charAt(i) = s.charAt(s.length()-i-1);
//
//            }
//        }
//    }
//}
