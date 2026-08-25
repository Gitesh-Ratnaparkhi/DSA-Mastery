// 3718. Smallest Missing Multiple of K

// Link -> https://leetcode.com/problems/smallest-missing-multiple-of-k/description/?envType=daily-question&envId=2026-08-18


// Approach -> Array
// Simple solution is to create an array of size 102 and mark the multiples of k as true. Then, we can iterate through the array and find the first missing multiple of k.

// Code -> 
class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean arr[] = new boolean[102];
        for(int i : nums){
            if(i % k == 0)arr[i] = true;
        }
        int temp = k;
        while(temp <=  101){
            if(!arr[temp]) return temp;
            temp += k;
        }
        return temp;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)