// 877. Stone Game


// Link : https://leetcode.com/problems/stone-game/description/

// Approach : Dynamic Programming


// Code ->
class Solution {

    int[][] dp = new int[501][501];

    private int solve(int i, int j, int[] piles) {

        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int ti = piles[i] + Math.min(solve(i + 2, j, piles), solve(i + 1, j - 1, piles));
        int tj = piles[j] + Math.min(solve(i, j - 2, piles), solve(i + 1, j - 1, piles));

        return dp[i][j] = Math.max(ti, tj);
    }

    public boolean stoneGame(int[] piles) {

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int sum = 0;
        for (int x : piles) sum += x;

        int alice = solve(0, piles.length - 1, piles);

        return alice > sum / 2;
    }
}

// Time Complexity : O(n^2)
// Space Complexity : O(n^2)


// Approach 2 : Mathematical Proof

// Code ->
class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
    }
}

// Time Complexity : O(1)
// Space Complexity : O(1)