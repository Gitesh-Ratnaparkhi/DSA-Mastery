// 3857. Minimum Cost to Split into Ones

// Link: https://leetcode.com/problems/minimum-cost-to-split-into-ones/description/

// Approach : Dynamic Programming
// 1. We will use a recursive function with memoization to find the minimum cost to split the number n into ones.
// 2. If n is even, we can split it into two equal parts and the cost will be a^2 + cost of splitting a + cost of splitting a, where a = n/2.
// 3. If n is odd, we can split it into n-1 and 1, and the cost will be (n-1) + cost of splitting n-1.
// 4. We will use a dp array to store the results of subproblems to avoid recalculating them.

// Code ->
class Solution {

    private int helper(int n, int dp[]) {
        if (n == 1)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        if (n % 2 == 0) {
            int a = n / 2;
            dp[n] = a * a + helper(a, dp) + helper(a, dp);
        } else {
            dp[n] = (n - 1) + helper(n - 1, dp);
        }
        return dp[n];
    }

    public int minCost(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)

// Approach 2 : Mathematical Proof
// 1. The minimum cost to split n into ones is equal to the sum of the first n-1
// natural numbers, which is (n*(n-1))/2.

// Code ->
class Solution {
    public int minCost(int n) {
        return (n * (n - 1) / 2);
    }
}

// Time Complexity : O(1)
// Space Complexity : O(1)