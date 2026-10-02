// 720. Longest Word in Dictionary
// Link: https://leetcode.com/problems/longest-word-in-dictionary/
// Difficulty: Medium
// Approach: Hash Set + Brute Force
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
    public String longestWord(String[] words) {
        Set<String> st = new HashSet<>();
        for(String i : words) st.add(i);
        String ans = "";
        for(int i=0; i<words.length; i++){
            String s = words[i];
            int n = s.length();
            boolean flag = true;
            for(int j = 1; j < n; j++){
                String prefix = s.substring(0, j);
                if (!st.contains(prefix)){
                    flag = false;
                    break;
                }
            }
            if(!flag) continue;
            ans = getBetterWord(ans , s);
        }
        return ans;
    }
}

// Time Complexity: O(n * m^2) where n is the number of words and m is the average length of the words. The inner loop checks each prefix of the word, which takes O(m) time, and we do this for each of the n words.
// Space Complexity: O(n) where n is the number of words. We use a hash set to store the words.