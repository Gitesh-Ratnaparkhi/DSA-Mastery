// 1690. Stone Game VII
// Link -> https://leetcode.com/problems/stone-game-vii/description/?envType=daily-question&envId=2026-07-26
// Approach -> Dynamic Programming [Medium]
// Code ->
class Solution {
    private int solve(int i, int j, int sum, int[] stones, int[][] dp) {
        if (i >= j)
            return 0;
        if (dp[i][j] != 0)
            return dp[i][j];

        int takeLeft = (sum - stones[i]) - solve(i + 1, j, sum - stones[i], stones, dp);
        int takeRight = (sum - stones[j]) - solve(i, j - 1, sum - stones[j], stones, dp);

        return dp[i][j] = Math.max(takeLeft, takeRight);
    }

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones)
            sum += stone;

        int dp[][] = new int[n][n];
        return solve(0, n - 1, sum, stones, dp);
    }
}

// Time Complexity: O(n^2) -> n is the number of stones
// Space Complexity: O(n^2) -> n is the number of stones