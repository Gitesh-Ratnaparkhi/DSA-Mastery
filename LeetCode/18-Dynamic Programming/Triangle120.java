// 120. Triangle
// Link -> https://leetcode.com/problems/triangle/
// Approach -> Dynamic Programming [Medium]
// Code ->
class Solution {
    private int m;

    private int solve(int i, int j, List<List<Integer>> triangle, int dp[][]) {
        if (i == m - 1)
            return triangle.get(i).get(j);
        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];
        return dp[i][j] = triangle.get(i).get(j)
                + Math.min(
                        solve(i + 1, j, triangle, dp),
                        solve(i + 1, j + 1, triangle, dp));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        m = triangle.size();
        int dp[][] = new int[m][triangle.get(m - 1).size()];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        return solve(0, 0, triangle, dp);
    }
}

// Time Complexity: O(m^2)
// Space Complexity: O(n^2)