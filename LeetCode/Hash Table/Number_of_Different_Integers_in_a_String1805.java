// 1805. Number of Different Integers in a String

// Link ->
// https://leetcode.com/problems/number-of-different-integers-in-a-string/description/

// Approach -> Hash Table [Medium]

// Code ->
class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> st = new HashSet<>();
        int i = 0, j = 0;
        boolean flag = false;

        while (i < word.length()) {
            char ch = word.charAt(i);

            if (Character.isLetter(ch) && flag) {
                st.add(trimLeadingZeros(word.substring(j, i)));
                flag = false;
                i++;
                j = i;
            } else if (Character.isDigit(ch)) {
                flag = true;
                i++;
            } else {
                i++;
                j++;
            }
        }

        if (flag) {
            st.add(trimLeadingZeros(word.substring(j, i)));
        }

        return st.size();
    }

    private String trimLeadingZeros(String s) {
        int k = 0;
        while (k < s.length() - 1 && s.charAt(k) == '0') {
            k++;
        }
        return s.substring(k);
    }
}

// Time Complexity O(n)
// Space Complexity O(n)