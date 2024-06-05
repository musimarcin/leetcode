//You are a professional robber planning to rob houses along a street.
// Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that
// adjacent houses have security systems connected and it will automatically contact the police if
// two adjacent houses were broken into on the same night.
//
//Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
// can rob tonight without alerting the police.

public class Problem198 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
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
