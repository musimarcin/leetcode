//Given an m x n matrix, return all elements of the matrix in spiral order.

import java.util.ArrayList;
import java.util.List;

public class Problem54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int lenRow = matrix.length;
        int lenCol = matrix[0].length;
        //set limiters at the beginning but set right and bottom a one out of bounds;
        int left = 0, right = lenCol, top = 0, bottom = lenRow;
        while (left < right && top < bottom) {
            //get everything from top row and remove it(set limiter from top)
            for (int i = left; i < right; i++) {
                result.add(matrix[top][i]);
            }
            top += 1;

            //get everything from right column and remove it(set limiter from right)
            for (int i = top; i < bottom; i++) {
                result.add(matrix[i][right - 1]);
            }
            right -= 1;

            //if limiters cross then break out of while loop (means there is no other spot to visit)
            if (!(left < right && top < bottom)) {
                break;
            }

            //get everything from bottom row and remove it(set limiter from bottom)
            for (int i = right - 1; i > left - 1; i--) {
                result.add(matrix[bottom - 1][i]);
            }
            bottom -= 1;

            //get everything from left column and remove it((set limiter from left)
            for (int i = bottom - 1; i > top - 1; i--) {
                result.add(matrix[i][left]);
            }
            left += 1;
        }
        return result;
    }
}
