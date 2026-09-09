// 3871. Count Commas in Range II
// https://leetcode.com/problems/count-commas-in-range-ii/description
// Level: Medium
// Approach: Brute Force
// Code -> 
class Solution {
    public long countCommas(long n) {

        if (n < 1000)
            return 0;

        long ans = 0;
        for (long i = 1000; i <= n; i++) {
            String s = Long.toString(i);
            int len = s.length();
            ans += (len - 1) / 3;
        }

        return ans;

    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// Note-> this code will give TLE for large values of n, we can optimize it by
// counting the number of commas in ranges of numbers with the same number of
// digits.

// Approach: Optimized Approach
// Code ->
class Solution {
    public long countCommas(long n) {
        long tc = 0;
        long th = 1000L;
        while (n >= th) {
            tc += (n - th + 1);
            if (th > Long.MAX_VALUE / 1000)
                break;
            th *= 1000L;
        }
        return tc;
    }
}

// Time Complexity: O(log n)
// Space Complexity: O(1)