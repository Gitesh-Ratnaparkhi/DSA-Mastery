// 3866. First Unique Even Element
// Link -> https://leetcode.com/problems/first-unique-even-element/description/
// Approach -> Counting [EASY]
// Code ->
class Solution {
    public int firstUniqueEven(int[] nums) {
        int arr[] = new int[51];
        for(int i : nums){
            if(i%2 == 0) arr[i/2]++;
        }
        for(int i : nums){
            if(i%2 == 0 && arr[i/2] == 1) return i;
        }
        return -1;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)