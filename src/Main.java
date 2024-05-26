import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Problem39 cs = new Problem39();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = cs.combinationSum(candidates, target);
        System.out.println(result);
    }
}