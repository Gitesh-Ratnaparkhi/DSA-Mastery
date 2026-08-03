// 813. Largest Sum of Averages

// Link -> https://leetcode.com/problems/largest-sum-of-averages/description/?envType=problem-list-v2&envId=dynamic-programming

// Approach -> Dynamic Programming
// The problem can be solved using dynamic programming. We can use a 2D array dp where dp[i][j] represents the maximum sum of averages we can get by partitioning the first i elements into j groups. We can iterate through the array and for each element, we can calculate the average of the current group and add it to the maximum sum of averages we can get from the previous groups. We can use a prefix sum array to calculate the average of the current group in O(1) time. Finally, we return dp[n][k] which represents the maximum sum of averages we can get by partitioning all n elements into k groups.

// Overlapping Subproblems -> The problem can be broken down into smaller subproblems. We can use the results of the smaller subproblems to solve the larger problem. For example, if we have already calculated the maximum sum of averages for the first i elements and j groups, we can use that result to calculate the maximum sum of averages for the first i+1 elements and j groups.

// Code ->
class Solution {

    int n;

    private double helper(double[] pres, int k, int idx, double[][] dp) {

        if (dp[idx][k] > 0)
            return dp[idx][k];

        if (k == 1)
            return (pres[n] - pres[idx]) / (n - idx);

        double max = 0;

        for (int i = idx + 1; i <= n - (k - 1); i++) {

            double avg = (pres[i] - pres[idx]) / (i - idx);

            max = Math.max(max, avg + helper(pres, k - 1, i, dp));
        }

        return dp[idx][k] = max;
    }

    public double largestSumOfAverages(int[] nums, int k) {

        n = nums.length;

        double[] presum = new double[n + 1];
        double[][] dp = new double[n + 1][k + 1];

        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }

        return helper(presum, k, 0, dp);
    }
}

// Time Complexity O(n² × k)
// Space Complexity O(n × k)