// 931. Minimum Falling Path Sum

// Link -> https://leetcode.com/problems/minimum-falling-path-sum/description/?envType=daily-question&envId=2026-07-26

// Approach -> Dynamic Programming
// 1. We can use dynamic programming to solve this problem.
// 2. We can use a 2D array dp to store the minimum falling path sum for each cell.
// 3. We can initialize the first row of the dp array with the first row of the matrix.
// 4. We can iterate through the matrix and update the dp array for each cell.
// 5. We can return the minimum falling path sum for the last row of the matrix.

// Code ->
class Solution {

    private int solve(int i, int j, int n, int grid[][], int dp[][]) {

        if (i == n - 1)
            return grid[i][j];
        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];
        int min = Integer.MAX_VALUE;

        if (j > 0)
            min = Math.min(min, solve(i + 1, j - 1, n, grid, dp));

        min = Math.min(min, solve(i + 1, j, n, grid, dp));
        if (j < n - 1)
            min = Math.min(min, solve(i + 1, j + 1, n, grid, dp));

        dp[i][j] = grid[i][j] + min;
        return dp[i][j];
    }

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++)
            ans = Math.min(ans, solve(0, j, n, matrix, dp));
        return ans;
    }
}

// Time Complexity -> O(n^2)
// Space Complexity -> O(n^2)