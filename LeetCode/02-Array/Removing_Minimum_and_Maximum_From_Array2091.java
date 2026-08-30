// 2091. Removing Minimum and Maximum From Array

// Link -> https://leetcode.com/problems/removing-minimum-and-maximum-from-array/description/?envType=daily-question&envId=2026-07-26

// Approach -> Brute Force [Medium]
// Code ->
class Solution {

    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        int minIndex = -1;
        int maxIndex = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == min) {
                minIndex = i;
            }

            if (nums[i] == max) {
                maxIndex = i;
            }
        }

        int left = Math.max(minIndex, maxIndex) + 1;

        int right = n - Math.min(minIndex, maxIndex);

        int both = Math.min(minIndex, maxIndex) + 1
                 + n - Math.max(minIndex, maxIndex);

        return Math.min(left, Math.min(right, both));
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)