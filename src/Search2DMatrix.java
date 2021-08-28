public class Search2DMatrix {
    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     *
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean result = false;
        int l = 0;
        int r = m*n-1;

        while (l <= r) {
            int mid = (l+r)/2;
            int midValue = matrix[mid/m][mid%m];
            if (midValue == target) {
                result = true;
                break;
            } else if (midValue > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;

    }
}
