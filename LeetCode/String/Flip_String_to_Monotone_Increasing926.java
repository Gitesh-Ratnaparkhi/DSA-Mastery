// 926. Flip String to Monotone Increasing
// Link -> https://leetcode.com/problems/flip-string-to-monotone-increasing/description/?envType=daily-question&envId=2026-07-26
// Level -> Medium
// Approach -> Greedy
// Code ->
class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int cnt = 0;
        int flip = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1') cnt++; 
            else flip++;
            flip=Math.min(flip,cnt);
        }
        return flip;
    }
}
// Time Complexity -> O(n)
// Space Complexity -> O(1)