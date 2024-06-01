//There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
// The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
//
//The island is partitioned into a heights of square cells. You are given an m x n integer matrix heights
// where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
//
//The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east,
// and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow
// from any cell adjacent to an ocean into the ocean.
//
//Return a 2D list of heights coordinates result where result[i] = [ri, ci] denotes that rain water can flow from
// cell (ri, ci) to both the Pacific and Atlantic oceans.

import java.util.ArrayList;
import java.util.List;

public class Problem417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        List<List<Integer>> result = new ArrayList<>();

        //check from top (pacific) to bottom(atlantic) for columns
        for (int i = 0; i < cols; i++) {
            helper(0, i, pacific, heights[0][i], heights);
            helper(rows - 1, i, atlantic, heights[rows - 1][i], heights);
        }
        //same but from left(pacific) to right(atlantic)
        for (int i = 0; i < rows; i++) {
            helper(i, 0, pacific, heights[i][0], heights);
            helper(i, i - 1, atlantic, heights[i][cols - 1], heights);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    result.add(tmp);
                }
            }
        }

        return result;
    }

    private void helper(int row, int col, boolean[][] visited, int height, int[][]heights) {
        // check boundaries visited and conditions for water flow
        if (    row < 0 ||
                row >= heights.length ||
                col < 0 ||
                col >= heights[0].length ||
                visited[row][col] ||
                heights[row][col] < height) {
            return;
        }

        // add position to visited set
        visited[row][col] = true;

        // look for a way for water in every direction
        helper(row + 1, col, visited, heights[row][col], heights);
        helper(row - 1, col, visited, heights[row][col], heights);
        helper(row, col + 1, visited, heights[row][col], heights);
        helper(row, col - 1, visited, heights[row][col], heights);
    }
}
