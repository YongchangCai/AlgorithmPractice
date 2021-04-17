import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */
public class RottenOrange {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int result = -1;
        int m = grid.length;
        int n = grid[0].length;
        boolean hasGood;
        do {
            hasGood = false;
            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                grid[node[0]][node[1]] = 2;
            }
            for (int i=0; i< m;i ++) {
                for (int j=0; j<n;j++) {
                    if (grid[i][j] == 2) {
                        addQueue(i, j, m, n, grid, queue);
                    }
                    if (grid[i][j] == 1) {
                        hasGood = true;
                    }
                }
            }
            result ++;
        } while (!hasGood || queue.isEmpty());
        if (hasGood) {
            return -1;
        } else {
            return result;
        }
    }

    private void addQueue(int i, int j, int m, int n, int[][]grid, Queue<int[]> queue) {
        if (i > 0 && grid[i-1][j] == 1) {
            queue.offer(new int[]{i-1,j});
        }
        if (j > 0 && grid[i][j-1] == 1) {
            queue.add(new int[]{i, j-1});
        }
        if (i < m-1 && grid[i+1][j] == 1) {
            queue.add(new int[]{i+1,j});
        }
        if (j < n-1 && grid[i][j+1] == 1) {
            queue.add(new int[]{i, j+1});
        }
    }
}
