// 2913. Subarrays Distinct Element Sum of Squares I
// Link -> https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/description/?envType=daily-question&envId=2026-07-26
// Level -> Easy
// Approach -> Hash Map 
// Code ->
class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        for(int i=0; i<nums.size(); i++){
            Set<Integer> st = new HashSet<>();
            for(int j=i; j<nums.size(); j++){
                st.add(nums.get(j));
                int si = st.size();
                ans += si * si;
            }
        }
        return ans;
    }
}
// Time Complexity -> O(n^2)
// Space Complexity -> O(n)