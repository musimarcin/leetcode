//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
//You must write an algorithm that runs in O(n) time.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Problem128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int number;
        int len = 0;
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.contains(nums[i] - 1)) {
                number = nums[i];
                while (hashSet.contains(number)) {
                    hashSet.remove(number);
                    number += 1;
                }
                if (len < number - nums[i]) {
                    len = number - nums[i];
                }
            }
        }
        return len;
    }
}
