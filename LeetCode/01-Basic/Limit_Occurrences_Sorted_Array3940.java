// 3940. Limit Occurrences in Sorted Array

// Link -> https://leetcode.com/problems/limit-occurrences-in-sorted-array/description/

// Approach -> Simple Linear Scan
// The problem is solved using a simple linear scan of the input array. The algorithm iterates through the array while keeping track of the current value and its count of occurrences. If the current value matches the previous value, the count is incremented. If the count is less than or equal to k, the value is added to a list. If the current value differs from the previous value, the count is reset to 1, and the new value is added to the list. Finally, the list is converted back to an array and returned as the result.

// Code ->

class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];

        List<Integer> arr = new ArrayList<>();

        int val = nums[0];
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {
                if (cnt < k) {
                    arr.add(nums[i]);
                }
                cnt++;
            } else {
                val = nums[i];
                cnt = 1;
                arr.add(nums[i]);
            }
        }

        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }

        return ans;
    }
}

// Time Complwexity: O(N)
// Space Complexity: O(N)