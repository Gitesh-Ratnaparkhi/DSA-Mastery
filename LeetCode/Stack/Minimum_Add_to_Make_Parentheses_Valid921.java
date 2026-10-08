// 921. Minimum Add to Make Parentheses Valid
// Link: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
// Deficulty: Medium
// Approach: Stack
// Code:
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') st.push(ch);
            else if(ch == ')' && !st.isEmpty()) st.pop();
            else if(ch == ')' && st.isEmpty()) ans ++;
        }
        ans += st.size();
        return ans;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)