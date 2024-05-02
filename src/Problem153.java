//Given the sorted rotated array nums of unique elements, return the minimum element of this array.
//
//You must write an algorithm that runs in O(log n) time.

public class Problem153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = Integer.MAX_VALUE;

        if (nums.length == 1) {
            return nums[0];
        }

        while (left <= right) {
            if (nums[left] < nums[right]) {
                result = Math.min(result, nums[left]);
                break;
            }
            int mid = left +(right - left) / 2;
            result = Math.min(result, nums[mid]);
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
