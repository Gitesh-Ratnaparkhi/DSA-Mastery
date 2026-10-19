// 3727. Maximum Alternating Sum of Squares
// Link -> https://leetcode.com/problems/maximum-alternating-sum-of-squares/description/?envType=daily-question&envId=2026-07-26
// Level -> Medium
// Approach -> Greedy
// Code ->
class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i =0; i<nums.length; i++) nums[i] = nums[i] * nums[i];
        Arrays.sort(nums);
        int n = nums.length / 2;
        long a1 = 0;
        long a2 = 0;
        for(int i=0; i<n; i++) a1 += nums[i];
        for(int i=n; i<nums.length ; i++) a2 += nums[i];
        return a2 - a1;
    }
}
// Time Complexity -> O(nlogn)
// Space Complexity -> O(n)
