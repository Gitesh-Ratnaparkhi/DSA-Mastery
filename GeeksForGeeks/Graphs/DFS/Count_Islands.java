// Count Islands

// Link -> https://practice.geeksforgeeks.org/problems/count-islands/1?utm_source=gfg&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

// Approch -> DFS [EASY]

// Code ->
class Solution {

    int n, m;

    private void dfs(int i, int j, char grid[][]) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 'W')
            return;
        grid[i][j] = 'W';
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);

        dfs(i - 1, j - 1, grid);
        dfs(i + 1, j - 1, grid);
        dfs(i + 1, j + 1, grid);
        dfs(i - 1, j + 1, grid);
    }

    public int countIslands(char[][] grid) {
        // Code here
        m = grid.length;
        n = grid[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'L') {
                    dfs(i, j, grid);
                    ans++;
                }
            }
        }
        return ans;
    }
}

// Time Complexity -> O(m*n)
// Space Complexity -> O(1)