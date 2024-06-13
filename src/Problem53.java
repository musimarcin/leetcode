//Given an integer array nums, find the subarray
// with the largest sum, and return its sum.

public class Problem53 {
    public int maxSubArray(int[] nums) {
        int sub = nums[0];
        int curr = 0;

        for (int num : nums) {
            //if current result is negative, reset (skip previous)
            if (curr < 0) curr = 0;
            curr += num;
            sub = Math.max(sub, curr);
        }

        return sub;
    }
}
