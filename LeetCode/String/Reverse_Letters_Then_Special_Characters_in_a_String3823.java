// 3823. Reverse Letters Then Special Characters in a String
// Link -> https://leetcode.com/problems/reverse-letters-then-special-characters-in-a-string/description/
// Level -> Easy
// Approach -> Stack
// Code ->
class Solution {
    public String reverseByType(String s) {
        Stack<Character> sign = new Stack<>();
        Stack<Character> al = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) al.push(ch);
            else sign.push(ch);
        }

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)) sb.append(al.pop());
            else sb.append(sign.pop());
        }
        return sb.toString();
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)