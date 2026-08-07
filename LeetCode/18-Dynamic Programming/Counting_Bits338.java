// 338. Counting Bits

// Link: https://leetcode.com/problems/counting-bits/

// Approach : Dynamic Programming
// 1. We will use a dp array to store the number of 1's in the binary representation of each number from 0 to n.
// 2. We will use a variable sub to keep track of the largest power of 2 that is less than or equal to the current number i.
// 3. For each number i, we will calculate the number of 1's in its binary representation by adding 1 to the number of 1's in the binary representation of (i - sub), where sub is the largest power of 2 less than or equal to i.
// 4. We will return the dp array.


// Code ->
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int sub = 1;

        for (int i = 1; i <= n; i++) {
            if (sub * 2 == i) {
                sub = i;
            }

            dp[i] = dp[i - sub] + 1;
        }

        return dp;        
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)