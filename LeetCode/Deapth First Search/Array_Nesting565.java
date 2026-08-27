// 565. Array Nesting
// Link -> https://leetcode.com/problems/array-nesting/description/?envType=daily-question&envId=2026-07-26
// Approach -> DFS  + DP [Medium]
// Code ->
class Solution {

    int dp[];

    private int solve(int i, int num[], boolean vis[]) {
        if (vis[i])
            return 0;
        if (dp[i] != -1)
            return dp[i];
        vis[i] = true;
        int val = 1 + solve(num[i], num, vis);
        return dp[i] = val;
    }

    public int arrayNesting(int[] nums) {
        int ans = 0;
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        for (int i = 0; i < nums.length; i++) {
            boolean vis[] = new boolean[nums.length];
            ans = Math.max(ans, solve(i, nums, vis));
        }
        return ans;
    }
}

// Time Complexity -> O(N^2)
// Space Complexity -> O(N)