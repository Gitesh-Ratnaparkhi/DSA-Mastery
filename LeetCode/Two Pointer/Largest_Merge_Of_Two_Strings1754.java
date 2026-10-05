// 1754. Largest Merge Of Two Strings
// Link -> https://leetcode.com/problems/largest-merge-of-two-strings/
// Level -> Medium

// Approach -> Two Pointer
// Code ->
class Solution {
    public String largestMerge(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        StringBuilder ans = new StringBuilder();
        int i = 0; 
        int j = 0;

        while (i < n1 && j < n2) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(j);

            if (ch1 > ch2) {
                ans.append(ch1);
                i++;
            } else if (ch2 > ch1) {
                ans.append(ch2);
                j++;
            } else {
                if (word1.substring(i).compareTo(word2.substring(j)) > 0) {
                    ans.append(ch1);
                    i++;
                } else {
                    ans.append(ch2);
                    j++;
                }
            }
        }

        if (i < n1) {
            ans.append(word1.substring(i));
        } else if (j < n2) {
            ans.append(word2.substring(j));
        }

        return ans.toString();
    }
}
// Time Complexity -> O(n1 + n2)
// Space Complexity -> O(n1 + n2)