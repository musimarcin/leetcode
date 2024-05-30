import java.util.LinkedList;
import java.util.Queue;

public class Problem200v2 {
    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid.length == 0) {
            return result;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    result += 1;
                    helper(grid, i, j);
                }
            }
        }
        return result;
    }
    private void helper(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        // mark as visited
        grid[row][col] = '0';

        int[][] dir = {
                {1, 0}, // down
                {-1, 0}, // up
                {0, 1}, // right
                {0, -1} // left
        };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for (int[] direction : dir) {
                int newRow = currRow + direction[0];
                int newCol = currCol + direction[1];

                // check if its outside of the board or already an island
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1') {
                    queue.offer(new int[]{newRow, newCol});
                    // mark as visited
                    grid[newRow][newCol] = '0';
                }
            }
        }
    }
}
