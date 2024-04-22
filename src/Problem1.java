
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int missing;
        for (int i = 0; i < nums.length; i++) {
            // calculating what number we're looking for
            missing = target - nums[i];
            //  if hashmap has that number return array with indexes
            if (hashMap.containsKey(missing)) {
                return new int[]{i, hashMap.get(missing)};
                // if not found put key as number and value as an array index
            } else {
                hashMap.put(nums[i], i);
            }
        }
        // return empty array if there are no solutions
        return new int[]{};
    }
}
