import java.util.HashMap;
import java.util.Map;

public class NumToString {
    /**
     * Convert a non-negative integer num to its English words representation.
     */

    private final String[] LESS_THAN_20 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion", "Trillion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int thousands = 0;
        int current = num;
        String result = "";

        while (current != 0) {
            int rem = current % 1000;
            if (rem != 0) {
                result += lowerNumToWords(rem) + " " + THOUSANDS[thousands];
            }
            current/=1000;
        }
        return result.trim();

    }

    private String lowerNumToWords(int num) {
        String result;
        if (num < 20) {
            result = LESS_THAN_20[num];
        } else if (num < 100) {
            result = TENS[num/10] + " " + lowerNumToWords(num%10);
        } else {
            result = LESS_THAN_20[num/100] + " Hundred " + lowerNumToWords(num%100);
        }
        return result;
    }
}
