// 459. Repeated Substring Pattern
// Link -> https://leetcode.com/problems/repeated-substring-pattern/description/
// Level -> Easy
// Approach -> Brute Force
// Code ->
class Solution {

    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();

        for (int len = 1; len <= n / 2; len++) {

            if (n % len != 0) continue;

            String st = s.substring(0, len);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n / len; i++) {
                sb.append(st);
            }

            if (sb.toString().equals(s)) {
                return true;
            }
        }

        return false;
    }
}
// Time Complexity -> O(n^2)
// Space Complexity -> O(1)