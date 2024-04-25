//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
// and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> hashSet = new HashSet<>();
        int left;
        int right;
        for (int fixed = 0; fixed < nums.length; fixed++) {
            left = fixed + 1;
            right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[fixed] > 0) {
                    right -= 1;
                } else if (nums[left] + nums[right] + nums[fixed] < 0) {
                    left += 1;
                } else if (nums[fixed] + nums[left] + nums[right] == 0) {
                    hashSet.add(new ArrayList<>(List.of(nums[fixed], nums[left], nums[right])));
                    right -= 1;
                    left += 1;
                }
            }
        }
        return new ArrayList<>(hashSet);
    }
}
