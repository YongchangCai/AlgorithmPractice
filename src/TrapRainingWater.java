import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */
public class TrapRainingWater {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int n = height.length;
        int[] left_high = new int[n];
        int[] right_high = new int[n];
        int total = 0;
        boolean trapping = false;
        left_high[0] = 0;
        right_high[n-1] = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if ( height[i] > left_high[i]) {
                left_high[i+1] = height[i];
            } else {
                left_high[i+1] = left_high[i];
            }
        }
        for (int j = n -1; j > 0; j--) {
            if (height[j]> right_high[j]) {
                right_high[j-1] = height[j];
            } else {
                right_high[j-1] = right_high[j];
            }
        }
        for (int k = 0; k < n; k++) {
            int min_high = Math.min(left_high[k], right_high[k]);
            if (height[k] < min_high) {
                total += min_high - height[k];
            }
        }

        return total;
    }
}
