// 1140. Stone Game II

// Link : https://leetcode.com/problems/stone-game-ii/description/

// Approach - Basic approach
// The problem can be easyly solved using recursion. We can use a helper function that takes the current index, the player (1 for Alice and 0 for Bob), the current value of M, and the piles array as parameters. The base case is when the index exceeds the length of the piles array, in which case we return 0.

// Code ->
class Solution {

    int n;

    private int helper(int i, int pla, int m, int[] piles) {
        if (i >= n)
            return 0;
        int res = (pla == 1) ? -1 : Integer.MAX_VALUE;
        int ans = 0;
        for (int x = 1; x <= Math.min(2 * m, n - i); x++) {

            ans += piles[i + x - 1];

            if (pla == 1) {
                res = Math.max(
                        res,
                        ans + helper(i + x, 0, Math.max(m, x), piles));
            } else {
                res = Math.min(
                        res,
                        helper(i + x, 1, Math.max(m, x), piles));
            }
        }

        return res;
    }

    public int stoneGameII(int[] piles) {
        n = piles.length;
        return helper(0, 1, 1, piles);
    }
}

// Time Complexity : O(n^3)
// Space Complexity : O(n^2)

// Approach -> Memoization
// The above approach can be optimized using memoization. We can use a 3D array
// to store the results of the helper function for each combination of index,
// player, and M value. This way, we can avoid recalculating the same results
// multiple times.

class Solution {

    int n;
    int[][][] dp;

    private int helper(int i, int pla, int m, int[] piles) {

        if (i >= n)
            return 0;

        if (dp[i][pla][m] != -1) {
            return dp[i][pla][m];
        }

        int res = (pla == 1) ? -1 : Integer.MAX_VALUE;
        int ans = 0;

        for (int x = 1; x <= Math.min(2 * m, n - i); x++) {

            ans += piles[i + x - 1];

            if (pla == 1) {
                res = Math.max(
                        res,
                        ans + helper(i + x, 0, Math.max(m, x), piles));
            } else {
                res = Math.min(
                        res,
                        helper(i + x, 1, Math.max(m, x), piles));
            }
        }

        return dp[i][pla][m] = res;
    }

    public int stoneGameII(int[] piles) {

        n = piles.length;

        dp = new int[n][2][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(0, 1, 1, piles);
    }
}

// Time Complexity -> O(n^3)
// Space Complexity -> O(n^2)