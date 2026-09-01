// 1922. Count Good Numbers
// Link -> https://leetcode.com/problems/count-good-numbers/description/?envType=daily-question&envId=2026-08-18

// Approach -> Math [MEDIUM]
// Code ->
class Solution {

    static final long MOD = 1000000007;

    private long pow(long val, long p) {
        if (p == 0) return 1;

        long half = pow(val, p / 2);
        long ans = (half * half) % MOD;

        if (p % 2 == 1) {
            ans = (ans * val) % MOD;
        }

        return ans;
    }

    public int countGoodNumbers(long n) {
        long evenPow = (n + 1) / 2;
        long oddPow = n / 2;

        return (int) ((pow(5, evenPow) * pow(4, oddPow)) % MOD);
    }
}

// Time Complexity -> O(N)
// Space Complexity -> O(1)