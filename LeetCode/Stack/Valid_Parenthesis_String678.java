// 678. Valid Parenthesis String
// Link -> https://leetcode.com/problems/valid-parenthesis-string/description/
// Level -> Medium
// Approach -> Stack
// Code ->
class Solution {
    public boolean checkValidString(String s) {

        int minOpen = 0;
        int maxOpen = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                minOpen++;
                maxOpen++;
            }
            else if (ch == ')') {
                minOpen--;
                maxOpen--;
            }else {
                minOpen--;
                maxOpen++;
            }
            if (maxOpen < 0) return false;
            minOpen = Math.max(0, minOpen);
        }
        return minOpen == 0;
    }
}
// Time Complexity -> O(n)
// Space Complexity -> O(1)