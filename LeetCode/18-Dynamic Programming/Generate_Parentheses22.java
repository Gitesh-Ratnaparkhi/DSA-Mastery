// 22 Generate Parentheses 
// Link -> https://leetcode.com/problems/generate-parentheses/description/
// Level -> Medium
// Approach -> Recursion
// Code ->
class Solution {

    private void solve(int n, int oprem, int clrem ,List<String> ans, String s){
        if(oprem == n && clrem == n){
            ans.add(s);
            return;
        }
        if(oprem < n) solve(n, oprem + 1, clrem ,ans, s+"(");
        if(clrem < oprem) solve(n, oprem , clrem + 1, ans, s+")");
        
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, 0 ,0 ,ans,"");
        return ans;
    }
}
// Time Complexity -> O(2n)
// Space Complexity -> O(n)