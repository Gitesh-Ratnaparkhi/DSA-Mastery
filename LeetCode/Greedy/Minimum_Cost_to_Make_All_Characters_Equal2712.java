// 2712. Minimum Cost to Make All Characters Equal
// Link -> https://leetcode.com/problems/minimum-cost-to-make-all-characters-equal/description/?envType=daily-question&envId=2026-07-26
// Level -> Medium
// Approach -> Greedy
// Code ->
class Solution {
    public long minimumCost(String s) {
        long ans = 0;
        int n = s.length();
        for(int i=1; i<n; i++){
            if(s.charAt(i) != s.charAt(i-1)) ans += Math.min(i, n-i);
        }
        return ans;
    }
}
// Time Complexity -> O(n)
// Space Complexity -> O(1)