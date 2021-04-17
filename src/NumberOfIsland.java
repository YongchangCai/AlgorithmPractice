/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIsland {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] gridCheck = new boolean[m][n];
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !gridCheck[i][j]) {
                    verifyGrid(i,j,grid,gridCheck);
                    result++;
                }
            }
        }
        return result;
    }

    private void verifyGrid(int i, int j, char[][] grid, boolean[][] gridCheck) {
        if (i < grid.length && j < grid[0].length && i>=0 &&j>=0 && !gridCheck[i][j]) {
            gridCheck[i][j] = true;
            if (grid[i][j] == '1') {
                verifyGrid(i+1, j, grid, gridCheck);
                verifyGrid(i, j+1, grid, gridCheck);
                verifyGrid(i-1, j, grid, gridCheck);
                verifyGrid(i, j-1, grid, gridCheck);
            }
        }
    }

}
