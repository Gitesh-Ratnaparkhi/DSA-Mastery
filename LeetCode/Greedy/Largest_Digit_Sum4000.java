// 4000. Largest Integer With Given Digit Sum

// Link -> https://leetcode.com/problems/largest-integer-with-given-digit-sum/

// Approach -> Brute Force
// The idea is to iterate from the largest possible number with n digits down to 0, and check if the sum of its digits equals s. If it does, return that number.

// Code ->
class Solution {
    public int largestInteger(int n, int s) {
        if (s > n * 9) return -1;
        int maxv = (int) Math.pow(10, n) - 1;
        for (int i = maxv; i >= 0; i--) {
            int sum = 0;
            int v = i;

            while (v > 0) {
                sum += v % 10;
                v /= 10;
            }
            if (sum == s)
                return i;
        }

        return -1;
    }
}

// Time complexity: O(n*10n)
// Space complexity: O(1)



