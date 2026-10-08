// 1486. XOR Operation in an Array
// Link - https://leetcode.com/problems/xor-operation-in-an-array/
// Level - Easy
// Topic - Bit Manipulation
// Code ->
class Solution {
    public int xorOperation(int n, int start) {
        int ans = 0;
        for(int i=0; i<n; i++){
            ans ^= start + ( 2 * i);
        }
        return ans;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(1)