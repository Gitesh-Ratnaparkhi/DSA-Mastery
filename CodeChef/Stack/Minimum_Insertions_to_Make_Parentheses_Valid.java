// Minimum Insertions to Make Parentheses Valid
// Link -> https://www.codechef.com/practice/course/strings-intermediate/STRINGSP02/problems/VALIDPAREN?tab=statement
// Level -> Easy
// Approach -> Stack
// Code ->
public static int minAddToMakeValidNaive(String s) {
    //write your code here...
    int n = s.length();
    Stack<Character> st = new Stack<>();
    int ans=0;
    for (int i = 0; i < s.length(); i++) {
           char ch = s.charAt(i);
           if (ch == '(') st.push(ch);
           else if(st.isEmpty() && ch == ')') ans++;
           else {
               if(!st.isEmpty() && st.peek() == '(' ) st.pop();
           }
       }
   ans += st.size();
   return ans;
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)