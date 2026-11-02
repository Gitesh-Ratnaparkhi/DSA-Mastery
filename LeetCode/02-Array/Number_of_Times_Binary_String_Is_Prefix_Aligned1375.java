// 1375. Number of Times Binary String Is Prefix-Aligned
// Link -> https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned/description/
// Level -> Medium
// Approach -> Linear Scan + Greatest Element Search
// Code ->
class Solution {
    public int numTimesAllBlue(int[] flips) {
        int ans = 0;
        int val = 0;
        for(int i=0; i<flips.length; i++){
            if(flips[i] > val) val = flips[i];
            if(val == i+1) ans++;
        }
        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)