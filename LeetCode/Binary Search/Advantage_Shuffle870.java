// 870. Advantage Shuffle

// Link -> https://leetcode.com/problems/advantage-shuffle/description/

// Approach -> 
// Flow of the Algorithm
// Sort nums1.
// Create ans[] and vis[].
// For each element in nums2:
// Perform binary search to find the first element greater than it.
// Skip already used elements.
// If no greater unused element exists, choose the smallest unused element.
// Store the selected value in ans.
// Mark it as visited.
// Return the final answer.

// Code ->
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.sort(nums1);
        for (int i = 0; i < n; i++) {
            int low = 0, high = n - 1;
            int idx = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums1[mid] > nums2[i]) {
                    idx = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (idx != -1) {
                while (idx < n && vis[idx]) {
                    idx++;
                }
            }
            if (idx == -1 || idx == n) {
                idx = 0;
                while (vis[idx]) {
                    idx++;
                }
            }
            ans[i] = nums1[idx];
            vis[idx] = true;
        }
        return ans;
    }
}


// Time Complexity: O(NlogN)
// Space Complexity: O(N)