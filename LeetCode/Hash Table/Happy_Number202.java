// 202. Happy Number
// Link -> https://leetcode.com/problems/happy-number/description/
// Approach -> Hash Set [Medium]
// Code ->
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> st = new HashSet<>();

        while (n != 1) {
            if (st.contains(n)) {
                return false;
            }
            st.add(n);

            int temp = n;
            int sum = 0;
            while (temp > 0) {
                int digit = temp % 10;
                sum += digit * digit;
                temp /= 10;
            }
            n = sum;
        }

        return true;
    }
}
// Time Complexity: O(log n)
// Space Complexity: O(log n)