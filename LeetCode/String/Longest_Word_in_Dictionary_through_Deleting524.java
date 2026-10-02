// 524. Longest Word in Dictionary through Deleting
// Link: https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
// Difficulty: Medium
// Approach: Brute Force
// Code:
class Solution {
    public static String getBetterWord(String w1, String w2) {
        if (w1.length() > w2.length()) return w1;
        else if (w2.length() > w1.length()) return w2;
        else{
            if (w1.compareTo(w2) < 0) return w1;
            else return w2;
        }
    }
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        int n = dictionary.size();
        for(int i=0; i<n; i++){
            int sn = s.length();
            String dir = dictionary.get(i);
            int dn = dir.length();
            if(sn < dn) continue;
            int idxs = 0;
            int idxd = 0;
            while(idxs < sn && idxd < dn){
                if(dir.charAt(idxd) == s.charAt(idxs))
                    idxd++;
                idxs++;
            }
            if(idxd != dn) continue;
            ans = getBetterWord(ans , dir);
        }
        return ans;
    }
}

// Time Complexity: O(N * S)
// Space Complexity: O(1)