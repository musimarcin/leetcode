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
        // sort array
        Arrays.sort(nums);
        HashSet<List<Integer>> hashSet = new HashSet<>();
        int left;
        int right;
        // iterate through array with one fixed number to calculate with pointers
        for (int fixed = 0; fixed < nums.length; fixed++) {
            // move left pointer next to fixed number and right at the end of array with every loop
            left = fixed + 1;
            right = nums.length - 1;
            while (left < right) {
                // if current left and right numbers are greater than 0 with fixed number then move right pointer
                // because its sorted array but if its greater move left pointer otherwise add solution as list to hashmap
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
