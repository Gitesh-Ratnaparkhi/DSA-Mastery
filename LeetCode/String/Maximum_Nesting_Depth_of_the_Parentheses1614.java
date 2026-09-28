// 1614. Maximum Nesting Depth of the Parentheses
// Link -> https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
// Level -> Easy
// Approach -> Simple Linear Scan
// Code ->
class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')cnt ++;
            else if(s.charAt(i) == ')'){
                ans = Math.max(ans , cnt);
                cnt--;
            }
        }
        return ans;
    }
}
// Time Complexity -> O(n)
// Space Complexity -> O(1)