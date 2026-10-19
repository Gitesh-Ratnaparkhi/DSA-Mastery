// 2089. Find Target Indices After Sorting Array
// Link -> https://leetcode.com/problems/find-target-indices-after-sorting-array/description/?envType=daily-question&envId=2026-07-26
// Difficulty -> Easy
// Approach -> Brute Force
// Code ->
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int cnt = 0;
        int idx = 0;
        for(int i : nums){
            if(i == target) cnt++;
            if(i < target) idx++;
        }
        List<Integer> ans = new ArrayList<>();
        while(cnt > 0){
            ans.add(idx);
            idx++;
            cnt--;
        }
        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)