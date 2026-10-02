// Balanced Parentheses
// Link -> https://www.naukri.com/code360/problems/balanced-paranthesis_8162202
// Level -> Easy
// Topic -> Stack
// Code ->
import java.util.Stack;
public class Balanced_Parentheses {
    public static boolean isBalanced(String s){
        // Write your code here.
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
// Time Complexity -> O(N)
// Space Complexity -> O(N)
