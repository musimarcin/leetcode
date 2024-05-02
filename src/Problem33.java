//Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
// or -1 if it is not in nums.
//
//You must write an algorithm with O(log n) runtime complexity.
public class Problem33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }

        while (left <= right) {
            int mid = Math.floorDiv((left + right), 2);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[mid] < target || nums[left] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target || nums[right] < target)  {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
