// 2958. Length of Longest Subarray With at Most K Frequency

// Link -> https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/


// Approach ->
// 1. We will use a sliding window approach to find the longest subarray with at most k frequency of any element.
// 2. We will use a HashMap to store the frequency of each element in the current window.
// 3. We will use two pointers i and j to represent the start and end of the window.
// 4. We will increment i until the frequency of nums[i] is less than or equal to k.
// 5. We will increment j until the frequency of nums[j] is greater than k.
// 6. We will update the maximum length of the subarray with at most k frequency of any element.

// Code ->
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0;
        int ans = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        while (i < n) {

            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            while (mp.get(nums[i]) > k) {
                mp.put(nums[j], mp.get(nums[j]) - 1);
                j++;
            }

            ans = Math.max(ans, i - j + 1);

            i++;
        }

        return ans;
    }
}


// Time Complexity -> O(n) where n is the length of the array nums
// Space Complexity -> O(n) where n is the length of the array nums