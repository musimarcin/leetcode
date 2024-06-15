//You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//
//You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
// DO NOT allocate another 2D matrix and do the rotation.

public class Problem48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length - 1;
        int left = 0, right = len;

        while (left < right) {
            //calculate number of "squares" to do
            for (int i = 0; i < (right - left); i++) {
                int top = left;
                int bottom = right;
                //save top left to tmp
                int tmp = matrix[top][left + i];
                //move corners of new square to the previous position with i to "rotate" square
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = tmp;
            }
            //update pointers to move inside (new square)
            left += 1;
            right -= 1;
        }
    }
}