// 1312. Minimum Insertion Steps to Make a String Palindrome

// Link -> https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/?envType=daily-question&envId=2026-07-26

// Approach -> Dynamic Programming [HARD]

// Code ->
class Solution {

    private int solve(int i, int j, String s, int dp[][]) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = solve(i + 1, j - 1, s, dp);
        } else {
            int left = solve(i + 1, j, s, dp);
            int right = solve(i, j - 1, s, dp);
            return dp[i][j] = 1 + Math.min(left, right);
        }
    }

    public int minInsertions(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        return solve(0, n-1, s, dp);
    }
}

// Time Complexity -> O(n^2)
// Space Complexity -> O(n^2)