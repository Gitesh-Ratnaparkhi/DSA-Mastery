// 2639. Find the Width of Columns of a Grid

// Link -> https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/description/

// Approach ->
// 1. We will iterate through each column of the grid and find the maximum and minimum values in that column.
// 2. We will then calculate the number of digits in the maximum and minimum values using the solve function.
// 3. We will store the result in the ans array.

// Code ->
class Solution {

    private int solve(int num) {
        long n = Math.abs((long) num);
        int ans = num <= 0 ? 1 : 0; 
        
        while (n > 0) {
            ans++;
            n /= 10;
        }
        return ans;
    }

    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans[] = new int[n];
        
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < m; j++) {
                max = Math.max(max, grid[j][i]);
                min = Math.min(min, grid[j][i]);
            }
            
            int val = Math.max(solve(max), solve(min));
            ans[i] = val;
            
        }
        return ans;
    }
}

// Time Complexity -> O(m * n)
// Space Complexity -> O(1)



// Approach 2 -> 
// 1. We will iterate through each cell of the grid and find the number of digits in that cell.
// 2. If the cell is negative, we will add 1 to the result.
// 3. We will store the result in the ans array.


// Code ->
class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] ans = new int[cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int val = grid[r][c];
                int len = 0;

                if (val <= 0) len++; 
                

                while (val != 0) {
                    len++;
                    val /= 10;
                }

                if (len > ans[c]) ans[c] = len;
                
            }
        }

        return ans;
    }
}


// Time Complexity -> O(m * n)
// Space Complexity -> O(1)