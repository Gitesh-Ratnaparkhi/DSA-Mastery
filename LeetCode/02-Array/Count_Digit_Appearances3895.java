//3895. Count Digit Appearances

// Link -> https://leetcode.com/problems/count-digit-appearances/description/


// Approach - Brute Force
// 1. Iterate through each number in the nums array.
// 2. For each number, extract its digits and check if any of them match the given digit.
// 3. If a match is found, increment the count.
// 4. Return the count.

// Code ->
class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int ans = 0;
        for(int i : nums){
            int a = i;
            while(a > 0){
                if(digit == a%10) ans++;
                a/=10;
            }
        }
        return ans;
    }
}

// Time Complexity: O(n * m) where n is the length of nums and m is the number of digits in the largest number in nums
// Space Complexity: O(1)