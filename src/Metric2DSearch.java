import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

/**
 * @author Yongchang Cai on 3/30/21
 */
public class Metric2DSearch {
    /**
     * Question: Write an efficient algorithm that searches for a value in an m x n matrix.
     * <p>
     * This matrix has the following properties:
     * <p>
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * <p>
     * Example 1:
     * Input:  [[5]],2
     * Output: false
     * <p>
     * Explanation:
     * false if not included.
     * <p>
     * Example 2:
     * Input:  [
     * [1, 3, 5, 7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ],3
     * Output: true
     * <p>
     * Explanation:
     * return true if included.
     */

    private static final Logger LOG = LoggerFactory.getLogger(Metric2DSearch.class);

    public boolean searchMatrixIdea1(int[][] matrix, int target) {
        /**
         * mid point search that start from mid array
         */

        boolean result = false;
        int length = matrix.length;
        if (matrix == null || length == 0) {
            LOG.error("unsupport matrix : {}", matrix);
        } else {
            result = midSearchMatrix(matrix, target, 0, length);
        }

        return result;
    }

    private boolean midSearchMatrix(int[][] matrix, int target, int start, int end) {
        boolean result = false;
        if (start < end) {
            int pivit = (end - start) / 2;
            int[] pivitArray = matrix[pivit];
            int arrayEnd = pivitArray.length;
            if (target < pivitArray[0]) {
                result = midSearchMatrix(matrix, target, start, pivit);
            } else if (target > pivitArray[arrayEnd - 1]) {
                result = midSearchMatrix(matrix, target, pivit + 1, end);
            } else {
                result = midSearchArray(pivitArray, target, 0, arrayEnd);
            }
        }
        return result;
    }

    private boolean midSearchArray(int[] array, int target, int start, int end) {
        boolean result = false;
        if (start < end) {
            int pivit = (end - start) / 2;
            if (target == array[pivit]) {
                result = true;
            } else if (target > array[pivit]) {
                result = midSearchArray(array, target, pivit + 1, end);
            } else {
                result = midSearchArray(array, target, start, pivit);
            }
        }
        return result;
    }
}
