//Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
// or vertically neighboring. The same letter cell may not be used more than once.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem79 {
    public boolean exist(char[][] board, String word) {
        //loop through board
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (helper(board, word, i, j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int row, int col, int i){
        if (i == word.length()) return true;

        // check if its outside of the board or character not matching
        if (row < 0 ||
                row >= board.length ||
                col < 0 ||
                col >= board[0].length ||
                board[row][col] != word.charAt(i))
            return false;

        // remove visited letters
        char tmp = board[row][col];
        board[row][col] = '*';

        // look for a letter
        boolean found =
                helper(board, word, row + 1, col, i + 1) || // down
                        helper(board, word, row - 1, col, i + 1) || // up
                        helper(board, word, row, col + 1, i + 1) ||  // right
                        helper(board, word, row, col - 1, i + 1);    // left

        // after looking from this position change back the character to normal
        board[row][col] = tmp;
        return found;
    }
}
