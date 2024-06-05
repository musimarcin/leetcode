//You are climbing a staircase. It takes n steps to reach the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class Problem70 {
    public int climbStairs(int n) {
        int one = 1, two = 1;
        for (int i = 0; i < n - 1; i++) {
            int tmp = one;
            //computing new previous value
            one = one + two;
            //moving pre-previous value as a previous value
            two = tmp;
        }
        return one;
        //return helper(n, 0);
    }
//less efficient dfs approach
    private int helper(int n, int curr) {
        if (curr == n) return 1;
        if (curr > n) return 0;
        return helper(n, curr + 1) + helper(n, curr + 2);
    }
}
