// 139. Word Break
// Link : https://leetcode.com/problems/word-break/description/
// Approach : Dynamic Programming [Medium]
// Code ->
class Solution {

    Boolean[] dp;

    private boolean solve(int idx, String s, Set<String> st) {

        if (idx == s.length()) {
            return true;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        for (int i = idx + 1; i <= s.length(); i++) {

            String part = s.substring(idx, i);

            if (st.contains(part) && solve(i, s, st)) {
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> st = new HashSet<>(wordDict);

        dp = new Boolean[s.length()];

        return solve(0, s, st);
    }
}

// Time Complexity : O(N^2)
// Space Complexity : O(N)