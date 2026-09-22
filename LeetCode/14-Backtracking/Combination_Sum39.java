// 39. Combination Sum
// Link: -> https://leetcode.com/problems/combination-sum/description/
// Level: Medium
// Approach: Backtracking
// Code ->
class Solution { 
    private void helper(int idx, int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp){ 
        if(idx >= candidates.length) { 
            if(target == 0) ans.add(new ArrayList<>(temp)); 
            return; 
        } 
        if(candidates[idx] <= target) { 
            temp.add(candidates[idx]); 
            helper(idx, candidates, target - candidates[idx], ans, temp); 
            temp.remove(temp.size() - 1); 
        } 
        helper(idx + 1, candidates, target, ans, temp); 
    } 

    public List<List<Integer>> combinationSum(int[] candidates, int target) { 
        List<List<Integer>> ans = new ArrayList<>(); 
        helper(0, candidates, target, ans, new ArrayList<>()); 
        return ans; 
    } 
}

// Time Complexity: O(2^n)
// Space Complexity: O(n)