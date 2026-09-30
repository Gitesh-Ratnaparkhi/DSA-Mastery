// 2267. Check if There Is a Valid Parentheses String Path
// Link -> https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/description/
// Level -> Hard
// Approach -> Dynamic Programming
// Code ->
class Solution {
    int m;
    int n;
    Boolean dp[][][]; 

    private boolean solve(int i, int j, char grid[][], int sum) {
        if (i >= m || j >= n) return false;

        if (grid[i][j] == '(') sum++;
        else sum--;

        if (sum < 0) return false;
        if (i == m - 1 && j == n - 1) return sum == 0;

        if (dp[i][j][sum] != null) return dp[i][j][sum];

        boolean down = solve(i + 1, j, grid, sum);
        boolean right = solve(i, j + 1, grid, sum);

        return dp[i][j][sum] = (down || right);
    }

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int mlen = (m + n) / 2;

        if ((m + n) % 2 == 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        dp = new Boolean[m][n][m + n];
        return solve(0, 0, grid, 0);
    }
}

// Time Complexity: O(m * n * (m + n)) -> m = number of rows, n = number of columns
// Space Complexity: O(m * n * (m + n)) -> m = number of rows, n = number of columns
