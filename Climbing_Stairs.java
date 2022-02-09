class Solution {
    public int waysToClimb(int i, int n, int[] memo) {
        if (memo[i] > 0) {
            return memo[i];
        }

        if (i > n) {
            return 0;
        } else if (i == n) {
            return 1;
        }

        memo[i] = waysToClimb(i + 1, n, memo) + waysToClimb(i + 2, n, memo);

        return memo[i];
    }

    public int climbStairs(int n) {
        int memo[] = new int[n + 3];

        return waysToClimb(0, n, memo);
    }
}