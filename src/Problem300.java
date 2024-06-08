//Given an integer array nums, return the length of the longest strictly increasing subsequence


import java.util.Arrays;

public class Problem300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        //every num is a subsequence itself, so fill with 1's
        Arrays.fill(dp, 1);
        int result = 0;
        //looping from end of array while checking every nums[j] that comes after nums[i]
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                //checking if increasing subsequence and updating current
                // dp[i] (longest increasing subsequence at this point)
                if (nums[i] < nums[j]) dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            //updating result every nums[i]
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    //O(nlogn) using binary search and DP
//      public int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }

//        int[] dp = new int[nums.length];
//        int length = 0;
//
//        for (int num : nums) {
//            int pos = binarySearch(dp, length, num);
//            dp[pos] = num;
//            if (pos == length) {
//                length++;
//            }
//        }
//
//        return length;
//    }
//
//    private int binarySearch(int[] dp, int length, int target) {
//        int left = 0, right = length;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (dp[mid] < target) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return left;
//    }
}