// Check if an Integer is Good

// Link -> https://leetcode.com/problems/check-if-an-integer-is-good/description/

// Approach -> Simple
// 1. Initialize two variables sqsum and digsum to 0.
// 2. While n is greater than 0, extract the last digit of n using n % 10 and add its square to sqsum and the digit itself to digsum.
// 3. Divide n by 10 to remove the last digit.
// 4. Return true if sqsum - digsum is greater than or equal to 50, otherwise return false.

// Code ->
class Solution {
    public boolean checkGoodInteger(int n) {
        int sqsum = 0, digsum = 0;
        while (n > 0) {
            int a = n % 10;
            sqsum += a * a;
            digsum += a;
            n /= 10;
        }
        return sqsum - digsum >= 50;
    }
}

// Time Complexity: O(log n) where n is the input integer
// Space Complexity: O(1)