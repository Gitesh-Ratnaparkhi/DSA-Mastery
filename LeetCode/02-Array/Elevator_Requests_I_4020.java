// 4020. Elevator Requests I
// Link -> https://leetcode.com/problems/elevator-requests-i/description/?envType=daily-question&envId=2026-07-26
// Difficulty -> Easy
// Approach -> Linear Search
// Code ->
class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int ans = 0;
        int prev = 0;
        for(int i : requests){
            ans += Math.abs(i - prev);
            prev = i;
        }
        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)