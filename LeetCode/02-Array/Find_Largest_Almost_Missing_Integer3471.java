// 3471. Find the Largest Almost Missing Integer

// Link -> https://leetcode.com/problems/find-the-largest-almost-missing-integer/description/?envType=daily-question&envId=2026-08-18

// Approach ->
// 1. There are four to five cases to consider:
//    - All numbers are missing.
//    - There is only one number missing.
//    - There are two numbers missing.
//    - There are three numbers missing.

// 2. For the first three cases, we can simply return the largest number in the array.
// 3. For second case, we can return the number that appears once.



// Code ->
class Solution {
    public int largestInteger(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int[] arr = new int[51];

        for (int i : nums) {
            arr[i]++;
            max = Math.max(max, i);
        }

        if (k == nums.length) return max;

        if (k == 1) {
            int ans = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) ans = Math.max(ans, i);
            }

            return ans;
        }

        int val1 = nums[0];
        int val2 = nums[nums.length - 1];

        if (arr[val1] == 1 && arr[val2] == 1) return Math.max(val1, val2);
        if (arr[val1] == 1) return val1;
        if (arr[val2] == 1) return val2;

        return -1;
    }
}


// Time Complexity -> O(N)
// Space Complexity -> O(1)