// 2859. Sum of Values at Indices With K Set Bits
// Link -> https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/description/?envType=daily-question&envId=2026-08-19
// Difficulty -> Easy
// Approach -> Bit Manipulation
// Code ->
class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for(int i=0; i<nums.size(); i++){
            int oc = Integer.bitCount(i);
            if(oc == k) ans += nums.get(i);
        }
        return ans;
    }
}
// Time Complexity -> O(n)
// Space Complexity -> O(1)