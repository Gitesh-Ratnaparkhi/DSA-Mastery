// 1111. Maximum Nesting Depth of Two Valid Parentheses Strings
// Link -> https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/description/
// Level -> Medium
// Approach -> Stack
// Code ->
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int ans[] = new int[n];
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = seq.charAt(i);
            if(ch == '('){
                st.push(ch);
                ans[i] = st.size() % 2 != 0 ? 0 : 1;

            }else{
                ans[i] = st.size() % 2 != 0 ? 0 : 1;
                st.pop();
            }

        }
        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)

// Approach 2 -> Simple Linear Scan
// Code ->

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int ans[] = new int[n];
        int temp = 0;
        for(int i=0; i<n; i++){
            char ch = seq.charAt(i);
            if(ch == '('){
                temp++;
                ans[i] = temp % 2;

            }else{
                ans[i] = temp % 2;
                temp--;
            }

        }
        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)