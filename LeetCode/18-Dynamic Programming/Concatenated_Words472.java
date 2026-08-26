// 472. Concatenated Words

// Link -> https://leetcode.com/problems/concatenated-words/description/?envType=study-plan-v2&envId=leetcode-75

// Approach -> Dynamic Programming [Hard]

// Code ->
class Solution {

    Boolean[] dp;

    private boolean solve(int idx, String s, Set<String> st) {

        if (idx == s.length()) return true;
        if (dp[idx] != null) return dp[idx];

        for (int i = idx + 1; i <= s.length(); i++) {
            String part = s.substring(idx, i);
            if (st.contains(part) && solve(i, s, st)) return dp[idx] = true;
        }
        return dp[idx] = false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> ans = new ArrayList<>();
        Set<String> st = new HashSet<>();
        for (String word : words) st.add(word);

        for (String word : words) {
            st.remove(word);
            dp = new Boolean[word.length()];
            if (solve(0, word, st)) ans.add(word);

            st.add(word);
        }

        return ans;
    }
}

// Time Complexity -> O(N^2 * M)
// Space Complexity -> O(N^2)