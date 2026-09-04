// 3693. Climbing Stairs II
// Link -> https://leetcode.com/problems/climbing-stairs-ii/description/?envType=daily-question&envId=2026-07-26
// Approach -> Dynamic Programming [Medium]
// Code ->
class Solution {

    private int solve(int i, int n, int costs[], int dp[]) {
        if (i == n) return 0;
        if (i > n) return Integer.MAX_VALUE;
        if(dp[i] != Integer.MAX_VALUE) return dp[i];
        int ans = Integer.MAX_VALUE;

        if (i + 1 <= n) {
            int next = solve(i + 1, n, costs, dp);
            if (next != Integer.MAX_VALUE) {
                int jumpCost = costs[i] + 1 * 1;
                ans = Math.min(ans, jumpCost + next);
            }
        }

        if (i + 2 <= n) {
            int next = solve(i + 2, n, costs, dp);
            if (next != Integer.MAX_VALUE) {
                int jumpCost = costs[i + 1] + 2 * 2;
                ans = Math.min(ans, jumpCost + next);
            }
        }

        if (i + 3 <= n) {
            int next = solve(i + 3, n, costs, dp);
            if (next != Integer.MAX_VALUE) {
                int jumpCost = costs[i + 2] + 3 * 3;
                ans = Math.min(ans, jumpCost + next);
            }
        }

        return dp[i] = ans;
    }

    public int climbStairs(int n, int[] costs) {
        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return solve(0, n, costs , dp);
    }
}

// Time Complexity: O(n) -> n is the number of stairs
// Space Complexity: O(n) -> n is the number of stairs