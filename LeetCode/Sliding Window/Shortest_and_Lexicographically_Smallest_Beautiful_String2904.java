// 2904. Shortest and Lexicographically Smallest Beautiful String
// Link -> https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/description/?envType=daily-question&envId=2026-07-26
// Approach -> Sliding Window [Medium]
// Code ->
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int i = 0, cnt = 0;
        String ans = "";

        for (int j = 0; j < n; j++) {
            if (s.charAt(j) == '1') {
                cnt++;
            }

            while (cnt == k) {
                while (s.charAt(i) == '0') {
                    i++;
                }

                String sub = s.substring(i, j + 1);
                if (ans.isEmpty() || sub.length() < ans.length() || 
                   (sub.length() == ans.length() && sub.compareTo(ans) < 0)) {
                    ans = sub;
                }

                cnt--;
                i++;
            }
        }

        return ans;
    }
}
// Time Complexity -> O(N)
// Space Complexity -> O(1)