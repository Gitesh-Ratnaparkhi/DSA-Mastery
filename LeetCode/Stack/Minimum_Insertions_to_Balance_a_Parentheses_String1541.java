// 1541. Minimum Insertions to Balance a Parentheses String
// Link -> https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
// Level -> Medium
// Approach -> Stack
// Code ->
class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            char temp;
            
            if(ch == '('){
                if(st.isEmpty() || st.peek() == '(') st.push(ch);
                else if(st.size() >= 2 && (temp = st.pop()) == ')' && st.peek() == ')' && ch == '('){
                    st.pop();
                    ans += 1;
                    st.push(ch);
                }else if(st.size() >= 2 && (temp = st.pop()) == '(' && st.peek() == ')' && ch == '('){
                    st.pop();
                    ans += 1;
                    st.push(ch);
                }else if(st.size() >= 2 && (temp = st.pop()) == '(' && st.peek() == '(' && ch == '('){
                    st.push(ch);
                }
            }
            else {
                if(i + 1 < s.length() && s.charAt(i + 1) == ')'){
                    i++;
                } else {
                    ans += 1;
                }
                if(st.isEmpty()){
                    ans += 1; 
                } else {
                    st.pop(); 
                }
            }
        }
        
        while(!st.isEmpty()){
            char top = st.pop();
            if(top == '(') ans += 2;
            else ans += 1;
        }
        
        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)


// Simplified Code ->
class Solution {
    public int minInsertions(String s) {
        int open=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                open++;
            }else{
                if(i+1<s.length() &&  s.charAt(i+1)==')'){
                    i++;
                }else{
                    ans++;
                }
            
                if(open>0)
                    open--;
                else ans++;
            
            }
        }
        ans+=2 * open;
        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)