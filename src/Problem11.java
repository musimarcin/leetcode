//You are given an integer array height of length n. There are n vertical lines drawn such that the
// two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//Return the maximum amount of water a container can store.
//
//Notice that you may not slant the container.

public class Problem11 {
    public int maxArea(int[] height) {
        //set pointers to beginning and end of array accordingly
        int left = 0;
        int right = height.length - 1;
        int result = 0;

        // loop through array with until left pointer meets right pointer
        while (left < right) {
            // calculate "water level" with distance between pointer and lower pole of pointers
            int tmp = (right - left) * (Math.min(height[right], height[left]));
            // if so then update result
            if (tmp > result) {
                result = tmp;
            }
            // if right pointer has higher pole move left pointer and if left is higher then move back right pointer
            if (height[right] > height[left]) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return result;
    }
}
