//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
// All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
// Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police
// if two adjacent houses were broken into on the same night.
//
//Given an integer array nums representing the amount of money of each house, return the maximum amount of
// money you can rob tonight without alerting the police.

import java.util.Arrays;

public class Problem213 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] startNums = Arrays.copyOfRange(nums, 0, nums.length-1);
        int[] endNums = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(robhelper(startNums), robhelper(endNums));
    }

    private int robhelper(int[] nums) {
        int prev = 0;
        int preprev = 0;
        for (int num : nums) {
            int tmp = prev;
            //calculating max loot from robbing previous house vs current + pre previous
            prev = Math.max(preprev + num, prev);
            //moving second behind element to first behind
            preprev = tmp;
        }
        return prev;
    }
}
