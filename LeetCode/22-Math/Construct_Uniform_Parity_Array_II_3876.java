// 3876. Construct Uniform Parity Array II
// Link -> https://leetcode.com/problems/construct-uniform-parity-array-ii/description
// Approach -> Greedy [Medium]
// Code ->
class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        for (int x : nums1) {
            min = Math.min(min, x);
        }
        if (min % 2 != 0)
            return true;
        for (int x : nums1) {
            if (x % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}

// Time Complexity: O(n) -> n is the length of the array
// Space Complexity: O(1) -> Constant space used