// 3819. Rotate Non Negative Elements
// Link -> https://leetcode.com/problems/rotate-non-negative-elements/description/?envType=daily-question&envId=2026-07-26
// Approach -> Brute Force [Medium]
// Code ->
class Solution {
    public int[] rotateElements(int[] nums, int k) {
        List<Integer> arr = new ArrayList<>();
        int ans[] = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) arr.add(i);
            else ans[i] = nums[i];
        }
        
        int m = arr.size();
        if (m == 0) return ans;
        
        k = k % m;
        
        for (int j = 0; j < m; j++) {
            int targetIdx = arr.get(j);
            int sourceIdx = arr.get((j + k) % m);
            ans[targetIdx] = nums[sourceIdx];
        }
        
        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)