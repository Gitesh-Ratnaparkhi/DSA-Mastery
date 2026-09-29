// 2811. Check if it is Possible to Split Array
// Link: https://leetcode.com/problems/check-if-it-is-possible-to-split-array/
// Level: Medium
// Approach: Greedy
// Code ->
class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        int n = nums.size();
        if(n <= 2)return true;
        for(int i=0; i<n-1; i++){
            if(nums.get(i) + nums.get(i+1) >= m) return true;
        }
        return false;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)