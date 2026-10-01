// 20. Valid Parentheses
// Link -> https://leetcode.com/problems/valid-parentheses/description/
// Level -> Easy
// Approach -> Stack
// Code ->
class Solution {
    public boolean isValid(String s) {
        if (s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']')
            return false;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[')
                st.push(ch);
            else {
                if (st.isEmpty())
                    return false;
                if (ch == ')' && st.peek() != '(')
                    return false;
                else if (ch == ']' && st.peek() != '[')
                    return false;
                else if (ch == '}' && st.peek() != '{')
                    return false;
                else
                    st.pop();
            }
        }

        return st.isEmpty() ? true : false;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)