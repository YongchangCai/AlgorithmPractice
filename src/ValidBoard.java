import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class ValidBoard {
    /**
     * Given a board and a end point find if it is possible to travel from every open cell on board.
     */

    public boolean isValidBoard(int[][]board, int[] endPoint) {
        if (board.length == 0 || board[0].length == 0) {
            return true;
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        boolean[][] visited = new boolean[board.length][board[0].length];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(endPoint);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                for (int[] direction : directions) {
                    int x = node[0] + direction[0];
                    int y = node[1] + direction[1];
                    if ( x >= board.length || x < 0 || y >= board[0].length || y < 0) {
                        continue;
                    }
                    if (board[x][y] == 0 && !visited[x][y]) {
                        queue.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }

        for (int i =0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void testIsValidBoard() {
        int[][] board1 = {{ 0,  0,  0, 0, -1},{0, -1, -1, 0,  0}, { 0,  0,  0, 0,  0 },{0, -1,  0, 0,  0},{0,  0,  0, 0,  0 },{0,  0,  0, 0,  0}};

        Assert.assertTrue(isValidBoard(board1, new int[]{0, 0}));

    }
}
