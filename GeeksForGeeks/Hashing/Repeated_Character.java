// Repeated Character
// Link: https://practice.geeksforgeeks.org/problems/repeated-character-1587115620/1

// Approach: Frequency Array [EASY]
// Simply iterate through the string and check if the frequency of each character is greater than 1. If it is, then return the character. Otherwise, return '#'.

// Code ->
class Solution {
    char firstRep(String S) {
        // your code here
        int ar1[] = new int[26];
        for(char ch : S.toCharArray()){
            ar1[ch - 'a']++;
        }
        for(char ch : S.toCharArray()){
            if(ar1[ch - 'a'] > 1) return ch;
        }
        return '#';

    }
}


// Time Complexity: O(n)
// Space Complexity: O(1)