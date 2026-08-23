// 3742. Maximum Path Score in a Grid

// Link -> https://leetcode.com/problems/maximum-path-score-in-a-grid/description/?envType=daily-question&envId=2026-07-26

// Approach -> DP [Medium]

// Code ->
class Solution {
    int m, n;

    private int solve(int i, int j, int k, int grid[][], int dp[][][]) {
        if (i >= m || j >= n)
            return -1;
        int nk = grid[i][j] == 0 ? k : k - 1;
        if (nk < 0)
            return -1;
        if (i == m - 1 && j == n - 1)
            return grid[i][j];
        if (dp[i][j][k] != -2)
            return dp[i][j][k];
        int max = Math.max(solve(i + 1, j, nk, grid, dp), solve(i, j + 1, nk, grid, dp));
        if (max == -1)
            return dp[i][j][k] = -1;
        return dp[i][j][k] = grid[i][j] + max;
    }

    public int maxPathScore(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -2);
            }
        }
        return solve(0, 0, k, grid, dp);
    }
}

// Time Complexity O(m*n*k)
// Space Complexity O(m*n*k)