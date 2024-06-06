//Given an integer array nums, find a subarray
// that has the largest product, and return the product.
//
//The test cases are generated so that the answer will fit in a 32-bit integer.

import java.util.Arrays;

public class Problem152 {
    public int maxProduct(int[] nums) {
        //kadane algorithm?
        int result = nums[0];
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            //if its negative, we swap values
            if (curr < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }

            max = Math.max(curr, max * curr);
            min = Math.min(curr, min * curr);

            result = Math.max(result, max);
        }

        return result;


        //cant pass [0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0] testcase
//        int result = Integer.MIN_VALUE;
//        //prefix and suffix for '0's in array
//        int prefix = 1;
//        int suffix = 1;
//        for (int i = 0; i < nums.length; i++) {
//            if (prefix == 0) prefix = 1;
//            if (suffix == 0) suffix = 1;
//            //multiply prefix from start of array and suffix from end of array as name suggest
//            prefix *= nums[i];
//            suffix *= nums[nums.length - i - 1];
//
//            result = Math.max(result, Math.max(prefix,suffix));
//        }
//
//        return result;

        //brute force
//        int result = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int curr = 1;
//            for (int j = i; j < nums.length; j++) {
//                curr *= nums[j];
//                result = Math.max(result, curr);
//            }
//        }
//        return result;
    }
}
