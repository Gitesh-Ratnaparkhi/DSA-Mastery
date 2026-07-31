// 3978. Unique Middle Element


// Link -> https://leetcode.com/problems/unique-middle-element/description/

// Approach -> simple linear scan.


// Code -> 
class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n = nums.length;
        int mid = nums[n/2];
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i] == mid){
                count++;
            }
        }
        return count==1;
    }
}


// Time Complexity: O(N)
// Space Complexity: O(1)