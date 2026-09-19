// 3546. Equal Sum Grid Partition I

// Link: -> https://leetcode.com/problems/equal-sum-grid-partition-i/description/
// Level: -> Medium
// Approach: Brute Force 
// Code ->
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long sum = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
            }
        }

        long temp = sum;
        long curr = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                curr += grid[i][j];
            }

            if(temp - curr == curr) return true;
        }

        curr = 0;

        for(int i = 0; i < grid[0].length; i++) {
            for(int j = 0; j < grid.length; j++) {
                curr += grid[j][i];
            }

            if(temp - curr == curr) return true;
        }

        return false;
    }
}

// Time Complexity: O(n*m) where n is the number of rows and m is the number of columns in the grid.
// Space Complexity: O(1)