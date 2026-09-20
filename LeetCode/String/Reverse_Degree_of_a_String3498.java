// 3498. Reverse Degree of a String
// Link -> https://leetcode.com/problems/reverse-degree-of-a-string/
// Level -> Easy
// Approach -> Simple Linear Scan
// Code ->  
class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            ans += ('z' - ch + 1) * (i+1);
        }
        return ans;
    }
}
// Time Complexity -> O(n)
// Space Complexity -> O(1)