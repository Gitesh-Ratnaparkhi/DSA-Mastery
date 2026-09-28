// Reverse Substrings Between Each Pair of Parentheses
// Link -> https://www.naukri.com/code360/problems/reverse-substrings-between-each-pair-of-parentheses_1473865
// Level -> Moderate
// Topic -> Stack + StringBuilder
// Code ->


public class Reverse_Substrings_Between_Each_Pair_of_Parentheses {
    public static String reverseStringsInParentheses(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        
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

// Time Complexity -> O(n)
// Space Complexity -> O(n)
