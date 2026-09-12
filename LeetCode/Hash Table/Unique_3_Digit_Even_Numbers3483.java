// 3483. Unique 3-Digit Even Numbers
// Link -> https://leetcode.com/problems/unique-3-digit-even-numbers/description/
// Level -> Easy
// Topic -> Hash Table
// Code ->
class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> st = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    int val = digits[i] * 100
                            + digits[j] * 10
                            + digits[k];

                    if (val % 2 == 0) {
                        st.add(val);
                    }
                }
            }
        }

        return st.size();
    }
}
// Time Complexity: O(n^3) where n is the length of the digits array
// Space Complexity: O(1)