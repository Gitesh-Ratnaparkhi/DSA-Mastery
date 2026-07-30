// 664. Strange Printer

// Link -> https://leetcode.com/problems/strange-printer/description/?envType=problem-list-v2&envId=dynamic-programming

// Approach -> Dynamic Programming
// The idea is to use a recursive function with memoization to find the minimum number of turns needed to print the string.


// Code ->
class Solution {
int[][] dp;

private int helper(String s, int i, int j) {
    if (i > j) return 0;
    if (i == j) return 1;

    if (dp[i][j] != -1) return dp[i][j];

    int k = i + 1;

    while (k <= j && s.charAt(k) == s.charAt(i)) {
        k++;
    }

    if (k == j + 1) {
        return dp[i][j] = 1;
    }

    int base = 1 + helper(s, k, j);

    int greed = Integer.MAX_VALUE;

    for (int l = k; l <= j; l++) {
        if (s.charAt(l) == s.charAt(i)) {
            int ans = helper(s, k, l - 1) + helper(s, l, j);
            greed = Math.min(greed, ans);
        }
    }

    return dp[i][j] = Math.min(base, greed);
}

public int strangePrinter(String s) {
    int n = s.length();
    dp = new int[n][n];

    for (int i = 0; i < n; i++) {
        Arrays.fill(dp[i], -1);
    }

    return helper(s, 0, n - 1);
}
}

// Time complexity: O(n^3)
// Space complexity: O(n^2)