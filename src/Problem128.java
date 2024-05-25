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
        // put numbers in hashset
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            // check if current number has a previous number (if its beginning of the sequence)
            if (!hashSet.contains(nums[i] - 1)) {
                // assign that value to a variable and check if its in hashset while increasing number until consecutive
                // numbers stops and removing them from set
                number = nums[i];
                while (hashSet.contains(number)) {
                    hashSet.remove(number);
                    number += 1;
                }
                // calculate length by subtracting increased number from beginning of the sequence
                if (len < number - nums[i]) {
                    len = number - nums[i];
                }
            }
        }
        return len;
    }
}
