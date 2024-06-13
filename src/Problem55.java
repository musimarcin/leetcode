//You are given an integer array nums. You are initially positioned at the array's first index,
// and each element in the array represents your maximum jump length at that position.
//
//Return true if you can reach the last index, or false otherwise.

public class Problem55 {
    public boolean canJump(int[] nums) {
        //assign goal to the end of array to move it
        int finish = nums[nums.length - 1];

        //start from end of the array while moving goal point if previous position can get to it and return true
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= finish) finish = i;
        }
        //if goal is at starting index then it means it can get to finish line
        return finish == 0;
    }
}
