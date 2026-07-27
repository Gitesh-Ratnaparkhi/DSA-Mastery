

// Link -> https://leetcode.com/problems/maximum-product-of-three-numbers/?envType=daily-question&envId=2026-07-26

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int ans2 = nums[0] * nums[1] * nums[n - 1];
        return Math.max(ans1, ans2);
    }
}
