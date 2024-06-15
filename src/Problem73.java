//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
//
//You must do it in place.

import java.util.ArrayList;
import java.util.List;

public class Problem73 {
    public void setZeroes(int[][] matrix) {
//        List<int[]> zeros = new ArrayList<>();
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == 0) zeros.add(new int[]{i,j});
//            }
//        }
//        for (int[] zero : zeros) {
//            helper(matrix, zero[0], zero[1]);
//        }

        //in place solution
        int lenRow = matrix.length;
        int lenCol = matrix[0].length;
        boolean setRowZero = false;

        //mark which rows and columns to zero
        for (int row = 0; row < lenRow; row++) {
            for (int col = 0; col < lenCol; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    if (row > 0) matrix[row][0] = 0;
                    else setRowZero = true;
                }
            }
        }

        //zero most of them
        for (int row = 1; row < lenRow; row++) {
            for (int col = 1; col < lenCol; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0) matrix[row][col] = 0;
            }
        }

        //zero first column
        if (matrix[0][0] == 0) {
            for (int row = 0; row < lenRow; row++) {
                matrix[row][0] = 0;
            }
        }

        //zero first row
        if (setRowZero) {
            for (int col = 0; col < lenCol; col++) {
                matrix[0][col] = 0;
            }
        }
    }
    private void helper(int[][] matrix, int h, int x) {
        int lenRow = matrix[0].length;
        int lenCol = matrix.length;

        //go right
        if (x < lenRow) {
            for (int i = x; i < lenRow; i++) {
                matrix[h][i] = 0;
            }
        }

        //go down
        if (h < lenCol) {
            for (int i = h; i < lenCol; i++) {
                matrix[i][x] = 0;
            }
        }

        //go left
        if (x > 0) {
            for (int i = x; i >= 0; i--) {
                matrix[h][i] = 0;
            }
        }

        //go up
        if (h > 0) {
            for (int i = h; i >= 0; i--) {
                matrix[i][x] = 0;
            }
        }
    }
}
