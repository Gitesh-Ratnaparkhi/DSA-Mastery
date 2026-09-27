// 1190. Reverse Substrings Between Each Pair of Parentheses
// Link -> https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/
// Level -> Medium
// Approach -> Stack + StringBuilder
// Code:
class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (s.charAt(i) == ')') {
                int start = st.pop();
                StringBuilder sub = new StringBuilder(sb.substring(start + 1, i));
                sb.replace(start + 1, i, sub.reverse().toString());
            }
        }
        
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' || sb.charAt(i) == ')') {
                sb.deleteCharAt(i);
            }
        }
        
        return sb.toString();
    }
}
// Time Complexity: O(n^2) in worst case due to substring and reverse operations
// Space Complexity: O(n)