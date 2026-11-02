// 3882. Minimum XOR Path in a Grid
// Link -> https://leetcode.com/problems/minimum-xor-path-in-a-grid/description/
// Level ->  Medium
// Approach -> dfs
// Code ->

class Solution {
    int n;
    int m;
    int ans;

    private void solve(int i, int j, int grid[][], int temp) {
        if(i < 0 || j < 0 || i >= n || j >= m) return;
        
        temp ^= grid[i][j];
        
        if(i == n-1 && j == m-1) {
            ans = Math.min(ans, temp);
            return;
        }
        
        solve(i, j+1, grid, temp);
        solve(i+1, j, grid, temp);
    }

    public int minCost(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        ans = Integer.MAX_VALUE;
        solve(0, 0, grid, 0);
        return ans;
    }
}

// This will give TLE

// Time Complexity -> O(n * m)
// Space Complexity -> O(n * m)


// Approach 2:
class Solution {

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean dp[][] = new boolean[m][1024];
        boolean nxt[] = new boolean[1024];


        dp[0][grid[0][0]] = true;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 && j == 0) continue;

                int val = grid[i][j];
                Arrays.fill(nxt, false);

                for(int k=0; k<1024; k++){
                    if(dp[j][k] || (j > 0 && dp[j-1][k])) nxt[k ^ val] = true;
                }
                System.arraycopy(nxt, 0, dp[j], 0, 1024);

            }
        }
        for (int k = 0; k < 1024; k++) {
            if (dp[m - 1][k]) {
                return k;
            }
        }

        return -1;
    }
}

// Time complexity: 