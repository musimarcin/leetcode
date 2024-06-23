//Given an array nums containing n distinct numbers in the range [0, n],
// return the only number in the range that is missing from the array.


public class Problem268 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        //result is set to lenght of nums because of final value in array
        int result = len;
        for (int i = 0; i < len; i++) {
            //becasue of xor nature (commutative and associative) the missing number will be in result and another
            // will cancel out each other
            result ^= i ^ nums[i];
            //sum method where two sums are substracted from each other and missing number will be result
//            result += (i - nums[i]);
        }
        return result;
    }
}
