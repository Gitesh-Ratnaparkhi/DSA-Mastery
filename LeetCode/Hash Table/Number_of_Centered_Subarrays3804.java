// 3804. Number of Centered Subarrays
// Link -> https://leetcode.com/problems/number-of-centered-subarrays/description/
// Approach -> Hash Map [Medium]
// Code ->
class Solution {
    public int centeredSubarrays(int[] nums) {
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            Set<Integer> st = new HashSet<>();
            st.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                st.add(nums[j]);
                if (st.contains(sum))
                    ans++;
            }
        }
        return ans;
    }
}

// Time Complexity -> O(n^2)
// Space Complexity -> O(n)