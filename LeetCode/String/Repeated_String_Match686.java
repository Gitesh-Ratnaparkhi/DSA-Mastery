// 686. Repeated String Match
// Link -> https://leetcode.com/problems/repeated-string-match/description/
// Level -> Medium
// Approach -> Brute Force
// Code ->
class Solution {
    public int repeatedStringMatch(String a, String b) {
        if (a.equals(b)) return 1;
        if (a.contains(b)) return 1;
        int ans = 1;
        StringBuilder sb = new StringBuilder(a);
        while (sb.length() < b.length() + a.length()) {
            sb.append(a);
            ans++;
            if (sb.toString().contains(b)) return ans;
        }
        return -1;
    }
}
// Time Complexity -> O(n * m) where n is the length of string a and m is the length of string b
// Space Complexity -> O(n)