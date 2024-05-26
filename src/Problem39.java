//Given an array of distinct integers candidates and a target integer target, return a list of all unique
// combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
//frequency
// of at least one of the chosen numbers is different.
//
//The test cases are generated such that the number of unique combinations that sum up to target is less than
// 150 combinations for the given input.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), candidates, target, 0);
        //helper2(0, 0, target, candidates, new ArrayList<>(), result);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> tmp, int[] candidates, int missing, int start) {
        // if value is greater than target theres no valid result
        if (missing < 0) return;
        // found new combination, adding to tmplist
        else if (missing == 0) {
            result.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                //select number
                tmp.add(candidates[i]);
                //pass a new missing value
                helper(result, tmp, candidates, missing - candidates[i], i);
                //remove last element added to backtrack
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    //neetcode approach with eliminating candidates while trying new combinations
    private void helper2(int i, int total, int target, int[] candidates, List<Integer> curr, List<List<Integer>> result) {
        if (total == target) {
            //create temporary list to not add modified curr list
            result.add(new ArrayList<>(curr));
        }
        // if theres no left candidates (i is outside of candidates array) or total is larger than target
        if (i >= candidates.length || total > target) {
            return;
        }
        curr.add(candidates[i]);
        // path where to total candidate is added
        helper2(i, total + candidates[i], target, candidates, curr, result);
        curr.remove(curr.size() - 1);
        // path where we pop candidate from list (to remove duplicates)
        helper2(i + 1, total, target, candidates, curr, result);
    }
}
