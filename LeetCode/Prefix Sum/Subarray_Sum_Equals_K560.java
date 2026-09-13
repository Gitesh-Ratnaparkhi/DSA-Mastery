// 560. Subarray Sum Equals K
// Link -> https://leetcode.com/problems/subarray-sum-equals-k/description/
// Level -> Medium
// Approach -> Prefix Sum
// Code ->
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int sum = 0;
        int ans = 0;

        mp.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (mp.containsKey(sum - k)) {
                ans += mp.get(sum - k);
            }

            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)