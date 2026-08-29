// 1574. Shortest Subarray to be Removed to Make Array Sorted
// Link -> https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/description/?envType=daily-question&envId=2026-07-26
// Approach -> Two Pointer [Medium]
// Code ->
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {

        int n = arr.length;

        int j = n - 1;
        while (j > 0 && arr[j - 1] <= arr[j]) {
            j--;
        }

        if (j == 0) return 0;
        int ans = j;
        int i = 0;
        while (i < j) {
            if (i > 0 && arr[i - 1] > arr[i]) {
                break;
            }

            while (j < n && arr[i] > arr[j]) {
                j++;
            }

            ans = Math.min(ans, j - i - 1);

            i++;
        }

        return ans;
    }
}

// Time Complexity -> O(N)
// Space Complexity -> O(1)