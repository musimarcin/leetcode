import java.util.HashSet;

//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

public class Problem217
{
    public boolean containsDuplicate(int[] nums) {
        // hashset has only unique items
        HashSet <Integer> hashNums = new HashSet<>();
        for (int num : nums) {
            // if adding a new number returns false it means that hashset already contains that number
            if (!hashNums.add(num)) {
                return true;
            }
        }
        return false;
    }
}
