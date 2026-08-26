// 140. Word Break II

// Link : https://leetcode.com/problems/word-break-ii/description/

// Approach : Dynamic Programming [Hard]

// Code ->
class Solution {
    private List<String> solve(int idx, String s, Set<String> st) {

    List<String> result = new ArrayList<>();

    if (idx == s.length()) {
        result.add("");
        return result;
    }

    for (int i = idx + 1; i <= s.length(); i++) {
        String part = s.substring(idx, i);
        if (st.contains(part)) {
            List<String> sub = solve(i, s, st);
            for (String str : sub) {
                if (str.equals("")) {
                    result.add(part);
                } else {
                    result.add(part + " " + str);
                }
            }
        }
    }

    return result;
}


    public List<String> wordBreak(String s, List<String> wordDict) {
        int n= s.length();
        List<String> ans = new ArrayList<>();

        Set<String> st = new HashSet<>();
        for(String a : wordDict){
            st.add(a);
        }
        return solve(0, s, st);
    }
}


// Time Complexity : O(2^n)
// Space Complexity : O(n)