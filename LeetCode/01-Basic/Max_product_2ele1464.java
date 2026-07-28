class Solution {
    public int maxProduct(int[] nums) {

        // Solution 1 as beginner

        // Arrays.sort(nums);
        // int n = nums.length;
        // int ans = (nums[n-1] - 1) * (nums[n-2] - 1);
        // if((nums[0] - 1) * (nums[1] - 1) > ans) ans = (nums[0] - 1) * (nums[1] - 1);
        // else if((nums[0] - 1) * (nums[n-1] - 1) > ans) ans = (nums[0] - 1) *
        // (nums[n-1] - 1);
        // return ans;

        // solution 2 adveance
        // Time complexcity O(n)
        // Space complexcity O(1)
        int m1 = 0, m2 = 0;
        for (int num : nums) {
            if (num > m1) {
                m2 = m1;
                m1 = num;
            } else if (num > m2) {
                m2 = num;
            }
        }
        return (m1 - 1) * (m2 - 1);
    }
}