// 1219. Path with Maximum Gold

// Link -> https://leetcode.com/problems/path-with-maximum-gold/description/

// Approach -> BackTracking
// 1. We can use backtracking to solve this problem.
// 2. We can use a recursive function to find the maximum gold that can be collected from a given cell.
// 3. We can use a boolean matrix visited to keep track of the cells that have already been visited.
// 4. We can return the maximum gold that can be collected from the starting cell.

// Code ->
class Solution {

    int m;
    int n;


    private int dfs(int grid[][], int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0)
            return 0;
        int back = grid[i][j];
        grid[i][j] = 0;
        int top = dfs(grid, i - 1, j);
        int left = dfs(grid, i, j - 1);
        int right = dfs(grid, i, j + 1);
        int bot = dfs(grid, i + 1, j);

        grid[i][j] = back;
        return grid[i][j] + Math.max(Math.max(top, bot), Math.max(left, right));
    }

    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0)
                    ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }
}

// Time Complexity: O(m*n)
// Space Complexity: O(m*n)