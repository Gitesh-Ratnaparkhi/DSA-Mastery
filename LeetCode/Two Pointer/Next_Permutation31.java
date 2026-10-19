// 31. Next Permutation
// Link -> https://leetcode.com/problems/next-permutation/
// Approach -> Two Pointer [Medium]
// Code ->
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        int start = i + 1;
        int end = nums.length - 1;
        
        while (start < end) {
            int tp = nums[start];
            nums[start] = nums[end];
            nums[end] = tp;
            start++;
            end--;
        }
    }
}

// Time Complexity -> O(N)
// Space Complexity -> O(1)