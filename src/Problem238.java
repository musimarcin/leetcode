//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.

public class Problem238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int prefix = 1;
        int suffix = 1;
        for (int i = 0; i < len; i++) {
            // put calculated prefix into result array
            result[i] = prefix;
            prefix *= nums[i];
        }
        for (int i = len - 1; i >= 0; i--) {
            // calculate final values by multiplying existing values in array with suffixes (caulculated by multiplying
            // current value with suffix)
            result[i] *= suffix;
            suffix *= nums[i];
        }
        return result;
    }
}
