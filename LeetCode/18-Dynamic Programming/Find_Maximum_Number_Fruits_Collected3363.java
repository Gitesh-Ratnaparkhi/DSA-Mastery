// 3363. Find the Maximum Number of Fruits Collected

// Link -> https://leetcode.com/problems/find-the-maximum-number-of-fruits-collected/description/?envType=daily-question&envId=2026-07-26

// Approach -> Dynamic Programming [Hard]

// Code ->
class Solution {
    int n;
    int INF = -1000000000;

    private int solveLeft(int i, int j, int limit, int[][] fruit, int[][] dp) {
        if (i < 0 || i >= n || j < 0 || j >= n)
            return INF;
        if (limit == 0)
            return (i == n - 1 && j == n - 1) ? fruit[i][j] : INF;
        if (i >= j)
            return INF;
        if (dp[i][j] != -1)
            return dp[i][j];

        int val = Math.max(
                solveLeft(i + 1, j - 1, limit - 1, fruit, dp),
                Math.max(
                        solveLeft(i + 1, j, limit - 1, fruit, dp),
                        solveLeft(i + 1, j + 1, limit - 1, fruit, dp)));

        return dp[i][j] = fruit[i][j] + val;
    }

    private int solveBot(int i, int j, int limit, int[][] fruit, int[][] dp) {
        if (i < 0 || i >= n || j < 0 || j >= n)
            return INF;
        if (limit == 0)
            return (i == n - 1 && j == n - 1) ? fruit[i][j] : INF;
        if (i <= j)
            return INF;
        if (dp[i][j] != -1)
            return dp[i][j];
        int val = Math.max(
                solveBot(i - 1, j + 1, limit - 1, fruit, dp),
                Math.max(
                        solveBot(i, j + 1, limit - 1, fruit, dp),
                        solveBot(i + 1, j + 1, limit - 1, fruit, dp)));

        return dp[i][j] = fruit[i][j] + val;
    }

    public int maxCollectedFruits(int[][] fruits) {
        n = fruits.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += fruits[i][i];
            fruits[i][i] = 0;
        }

        int[][] dpLeft = new int[n][n];
        int[][] dpBot = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dpLeft[i], -1);
            Arrays.fill(dpBot[i], -1);
        }

        ans += solveLeft(0, n - 1, n - 1, fruits, dpLeft);
        ans += solveBot(n - 1, 0, n - 1, fruits, dpBot);

        return ans;
    }
}

// Time Complexity -> O(n^2)
// Space Complexity -> O(n^2)