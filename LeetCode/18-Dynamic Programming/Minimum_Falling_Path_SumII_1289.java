// 1289. Minimum Falling Path Sum II


// Link -> https://leetcode.com/problems/minimum-falling-path-sum-ii/description/?envType=daily-question&envId=2026-07-26

// Approach -> Dynamic Programming
// 1. We can use dynamic programming to solve this problem.
// 2. We can use a 2D array dp to store the minimum falling path sum for each cell.
// 3. We can initialize the first row of the dp array with the first row of the matrix.
// 4. We can iterate through the matrix and update the dp array for each cell.
// 5. We can return the minimum falling path sum for the last row of the matrix.

// Code ->
class Solution {

    private int solve(int i, int j, int n, int grid[][], int dp[][]) {

        if (i == n - 1) return grid[i][j];

        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            if (k != j) min = Math.min(min, solve(i + 1, k, n, grid, dp));
        }

        dp[i][j] = grid[i][j] + min;
        return dp[i][j];
    }

    public int minFallingPathSum(int[][] grid) {

        int n = grid.length;

        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) ans = Math.min(ans, solve(0, j, n, grid, dp));

        return ans;
    }
}

// Time Complexity -> O(N^3)
// Space Complexity -> O(N^2)


// Approach 2


// Code ->
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 1) return grid[0][0];

        // Track the two smallest values and the index of the smallest from the previous row
        int prevMin1 = 0, prevMin2 = 0, prevMin1Idx = -1;

        for (int[] row : grid) {
            int currMin1 = Integer.MAX_VALUE;
            int currMin2 = Integer.MAX_VALUE;
            int currMin1Idx = -1;

            for (int j = 0; j < n; j++) {
                // If the current column matches the previous row's minimum column, use the second minimum
                int val = row[j] + (j == prevMin1Idx ? prevMin2 : prevMin1);

                // Update the current row's minimums
                if (val < currMin1) {
                    currMin2 = currMin1;
                    currMin1 = val;
                    currMin1Idx = j;
                } else if (val < currMin2) {
                    currMin2 = val;
                }
            }

            prevMin1 = currMin1;
            prevMin2 = currMin2;
            prevMin1Idx = currMin1Idx;
        }

        return prevMin1;
    }
}

// Time Complexity -> O(N^2)
// Space Complexity -> O(1)