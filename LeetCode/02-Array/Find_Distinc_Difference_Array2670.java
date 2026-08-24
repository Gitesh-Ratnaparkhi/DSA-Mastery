// 2670. Find the Distinct Difference Array

// Link : https://leetcode.com/problems/find-the-distinct-difference-array/description/?envType=daily-question&envId=2026-07-26

// Approach -> Brute Force

// Code ->
class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] ans = new int[n];

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            prefix[i] = set.size();
        }

        set.clear();

        for (int i = n - 1; i >= 0; i--) {
            set.add(nums[i]);
            suffix[i] = set.size();
        }

        for (int i = 0; i < n; i++) {
            int suffixCount = (i + 1 < n) ? suffix[i + 1] : 0;

            ans[i] = prefix[i] - suffixCount;
        }

        return ans;
    }
}

// Time Complexity -> O(N)
// Space Complexity -> O(N)