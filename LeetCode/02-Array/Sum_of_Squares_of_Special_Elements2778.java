// 2778. Sum of Squares of Special Elements
// Link -> https://leetcode.com/problems/sum-of-squares-of-special-elements/description/?envType=daily-question&envId=2026-07-26
// Approach -> Brute Force [Easy]
// Code ->


class Solution {
    public int sumOfSquares(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            int temp = i+1;
            if(n % temp == 0) sum += nums[i] * nums[i];
        }
        return sum;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)