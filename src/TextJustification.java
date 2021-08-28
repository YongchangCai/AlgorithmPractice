import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words.length <= 1 || maxWidth < 1) {
            return Arrays.asList(words);
        }
        List<String> result = new ArrayList<>();
        int left = 0;

        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            result.add(justifyString(left, right, words, maxWidth));
            left = right + 1;
        }
        return result;
    }

    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int length = 0;
        while (right < words.length && length <= maxWidth) {
            length+= words[right].length();
            right++;
        }

        return right - 1;
    }

    private String justifyString(int left, int right, String[] words, int maxWidth) {
        if (right == left) {
            return padResult(words[left], maxWidth);
        }
        boolean isLastLine = right == words.length - 1;
        int numSpace = right - left;
        int totalSpace = maxWidth - wordLength(left, right, words);

        String spaces = isLastLine ? " " : blank(totalSpace/numSpace);
        int remainder = isLastLine ? 0 : totalSpace%numSpace;

        StringBuilder sb = new StringBuilder();
        for (int i = left; i <= right; i++) {
            sb.append(words[i]).append(spaces).append(remainder-- > 0 ? " " : "");
        }
        return padResult(sb.toString().trim(),maxWidth);
    }

    private int wordLength(int left, int right, String[] words) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            result += words[i].length();
        }
        return result;
    }

    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }

    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }

}
