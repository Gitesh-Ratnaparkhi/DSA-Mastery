// 2945. Find Maximum Non-decreasing Array Length
// Link -> https://leetcode.com/problems/find-maximum-non-decreasing-array-length/description/?envType=daily-question&envId=2026-07-26
// Approach -> Recusion DP first approach [Hard] 
// This approach will give tle.
// Code
class Solution {

    HashMap<String, Integer> dp = new HashMap<>();

    private int solve(int i, long prev, int n, int[] num) {

        if (i == n) return 0;

        String key = i + "," + prev;

        if (dp.containsKey(key))
            return dp.get(key);

        long sum = 0;
        int ans = 0;

        for (int j = i; j < n; j++) {

            sum += num[j];

            if (sum >= prev) {
                ans = Math.max(ans,
                    1 + solve(j + 1, sum, n, num));
            }
        }

        dp.put(key, ans);
        return ans;
    }

    public int findMaximumLength(int[] nums) {
        return solve(0, 0, nums.length, nums);
    }
}

// Time complexity -> O(N^2)
// Space complexity -> O(N^2)

// Approach 2 -> Prefix Sum
// Code ->
