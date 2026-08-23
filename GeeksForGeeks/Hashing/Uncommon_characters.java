// Uncommon characters

// Link: https://practice.geeksforgeeks.org/problems/uncommon-characters/0

// Approach: 26 Size Array [EASY]

// Code ->
class Solution {
    String uncommonChars(String s1, String s2) {

        boolean ar1[][] = new boolean[26][2];

        for (char ch : s1.toCharArray()) {
            ar1[ch - 'a'][0] = true;
        }

        for (char ch : s2.toCharArray()) {
            ar1[ch - 'a'][1] = true;
        }

        String ans = "";

        for (int i = 0; i < 26; i++) {
            if ((!ar1[i][0] && ar1[i][1]) || 
                (ar1[i][0] && !ar1[i][1])) {

                ans += (char)(i + 'a');
            }
        }

        return ans;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1)