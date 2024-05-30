//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem200 {
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
    private void helper(char[][] grid, int row, int col){

        // check if its outside of the board or character not matching
        if (row < 0 ||
                row >= grid.length ||
                col < 0 ||
                col >= grid[0].length ||
                grid[row][col] == '0') {
            return;
        }

        // remove visited letters
        char tmp = grid[row][col];

        grid[row][col] = '0';

        // look for a letter
        helper(grid, row + 1, col);
        helper(grid, row - 1, col);
        helper(grid, row, col + 1);
        helper(grid, row, col - 1);
    }
}
