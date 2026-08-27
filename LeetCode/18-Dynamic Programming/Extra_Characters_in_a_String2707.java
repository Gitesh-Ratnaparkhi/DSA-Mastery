// 2707. Extra Characters in a String
// Link : https://leetcode.com/problems/extra-characters-in-a-string/description/
// Approach : Dynamic Programming [Medium]
// Code ->
class Solution {
    private int solve(int i, String s, Set<String> st, Integer[] dp) {
        if (i >= s.length()) return 0;
        if (dp[i] != null) return dp[i];

        int ans = 1 + solve(i + 1, s, st, dp);

        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);
            if (st.contains(sub)) {
                ans = Math.min(ans, solve(j + 1, s, st, dp));
            }
        }

        return dp[i] = ans;
    }

    public int minExtraChar(String s, String[] dictionary) {
        Set<String> st = new HashSet<>(Arrays.asList(dictionary));
        Integer[] dp = new Integer[s.length()];
        return solve(0, s, st, dp);
    }
}

// Time Complexity : O(N^2)
// Space Complexity : O(N)