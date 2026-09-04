// 3903. Smallest Stable Index I
// Link -> https://leetcode.com/problems/smallest-stable-index-i/description/?envType=daily-question&envId=2026-07-26
// Approach -> Brute Force [Easy]
// Code -> 
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        
        for(int i=0; i<nums.length; i++){
            int max = 0;
            int j = 0;
            while(j <= i){
                max = Math.max(max, nums[j]);
                j++;
            }
            int min = Integer.MAX_VALUE;
            j = i;
            while(j < nums.length){
                min = Math.min(min, nums[j]);
                j++;
            }
            if(max - min <= k) return i;
        }
        return -1;
    }
}

// Time Complexity: O(n^2) -> n is the number of elements in the array
// Space Complexity: O(1) -> Constant space used