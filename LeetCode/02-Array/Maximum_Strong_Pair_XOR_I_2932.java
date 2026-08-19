// 2932. Maximum Strong Pair XOR I

// Link -> https://leetcode.com/problems/maximum-strong-pair-xor-i/description/?envType=daily-question&envId=2026-07-26

// Approach -> Brute Force
// 1. We can iterate through the array and find the maximum XOR value between any two elements.
// 2. We can return the maximum XOR value.

// Code ->
class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int xor = nums[i] ^ nums[j];
                if(Math.abs(nums[i] - nums[j]) <= Math.min(nums[i] , nums[j]) && ans < xor){
                    ans = xor;
                }
            }
        }
        return ans;
    }
}

// Time Complexity -> O(n^2)
// Space Complexity -> O(1)