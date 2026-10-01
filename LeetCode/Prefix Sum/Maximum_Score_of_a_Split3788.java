// 3788. Maximum Score of a Split
// Link -> https://leetcode.com/problems/maximum-score-of-a-split/
// Level -> Medium
// Approach -> Brute Force [Medium]
// Code ->
class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long ans = Integer.MIN_VALUE;
        int suff[] = new int[n];
        suff[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) suff[i] = Math.min(nums[i] , suff[i+1]);
        long sum = 0;
        for(int i=0; i<n-1; i++){
            sum+=nums[i];
            ans = Math.max(ans , sum - suff[i+1]);
        }
        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)