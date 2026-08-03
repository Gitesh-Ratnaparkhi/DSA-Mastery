// 1406. Stone Game III

// Link : https://leetcode.com/problems/stone-game-iii/description/

// Approach : Dynamic Programming ,Top down approach
// In this approach we will use recursion with memoization to find the maximum difference of score between Alice and Bob. We will use a dp array to store the results of subproblems to avoid recalculating them. The function solve(i) will return the maximum difference of score starting from index i. We will consider taking 1, 2, or 3 stones and calculate the score accordingly. Finally, we will return the maximum difference of score between Alice and Bob. Note that if the difference is positive, Alice wins, if it is negative, Bob wins, and if it is zero, it's a tie.

// Code ->
class Solution {

    int n;
    int[] dp;

    private int solve(int i, int[] stone) {
        if (i >= n)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int ans = stone[i] - solve(i + 1, stone);

        if (i + 1 < n)
            ans = Math.max(ans,
                    stone[i] + stone[i + 1] - solve(i + 2, stone));

        if (i + 2 < n)
            ans = Math.max(ans,
                    stone[i] + stone[i + 1] + stone[i + 2] - solve(i + 3, stone));

        return dp[i] = ans;
    }

    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int dif = solve(0, stoneValue);

        if (dif == 0)
            return "Tie";
        return dif > 0 ? "Alice" : "Bob";
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)

// Approach 2 : Dynamic Programming ,Bottom up approach

// Code ->
class Solution {

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            int take = 0;
            dp[i] = Integer.MIN_VALUE;

            for (int k = 0; k < 3 && i + k < n; k++) {
                take += stoneValue[i + k];
                dp[i] = Math.max(dp[i], take - dp[i + k + 1]);
            }
        }

        if (dp[0] == 0)
            return "Tie";
        return dp[0] > 0 ? "Alice" : "Bob";
    }
}

// Time Complexity : O(n)
// Space Complexity :