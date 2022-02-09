class Solution {
    public int recursiveTribonacci(int[] memo, int n) {
        if (memo[n] != -1) {
            return memo[n];
        } else {
            memo[n] = recursiveTribonacci(memo, n - 1) + recursiveTribonacci(memo, n - 2)
                    + recursiveTribonacci(memo, n - 3);
        }

        return memo[n];
    }

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }

        int memo[] = new int[n + 1];
        int i = 0;
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;

        for (i = 3; i <= n; i++) {
            memo[i] = -1;
        }

        return recursiveTribonacci(memo, n);
    }
}