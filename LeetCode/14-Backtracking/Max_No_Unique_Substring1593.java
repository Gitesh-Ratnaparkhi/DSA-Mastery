// 1593. Split a String Into the Max Number of Unique Substrings

// Link -> https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/description/

// Approach: Backtracking
// We use a backtracking approach to generate all possible unique substrings of the given string. We maintain a set to keep track of the unique substrings we have seen so far. At each step, we try to add a new substring to the set and recursively call the helper function to explore further. If we reach the end of the string, we update the maximum count of unique substrings found so far.

// Code -> 
class Solution {

    int ans = 0;

    private void helper(int i, int n, String s, Set<String> st) {

        if (i > n) {
            ans = Math.max(ans, st.size());
            return;
        }

        for (int j = i; j <= n; j++) {
            String sub = s.substring(i, j + 1);

            if (!st.contains(sub)) {
                st.add(sub);
                helper(j + 1, n, s, st);
                st.remove(sub);
            }
        }
    }

    public int maxUniqueSplit(String s) {
        helper(0, s.length() - 1, s, new HashSet<>());
        return ans;
    }
}

// Time Complexity: O(n * 2^n) where n is the length of the string. In the worst
// case, we can have 2^n possible substrings and for each substring, we may need
// to check if it is unique or not which takes O(n) time.
// Space Complexity: O(n) where n is the length of the string. The space is used
// by the recursion stack and the set to store unique substrings.
