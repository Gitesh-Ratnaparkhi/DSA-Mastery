// 1575. Count All Possible Routes


// Link -> https://leetcode.com/problems/count-all-possible-routes/description/

// Approach -> Dynamic Programming
// 1. Initialize a 2D array dp[n][f] to store the number of possible routes from location i to location j with f fuel.
// 2. Initialize all elements of dp to -1 to indicate that the subproblem has not been solved yet.
// 3. Define a recursive function solve(i, j, f) that returns the number of possible routes from location i to location j with f fuel.
// 4. If the subproblem has already been solved, return the value stored in dp[i][f].
// 5. If i == j, return 1 as there is only one possible route.
// 6. If f is less than 0, return 0 as there are no possible routes with negative fuel.
// 7. Initialize ans to 0.
// 8. Iterate through all locations j except i.
// 9. Calculate the cost of moving from location i to location j.
// 10. If the cost is less than or equal to f, add the number of possible routes from location j to location j with f - cost to ans.
// 11. Return ans as the number of possible routes from location i to location j with f fuel.

// Code ->
class Solution {

    int MOD = 1000000007;
    int[][] dp;

    private int solve(int[] loc, int st, int fin, int fuel) {

        if (fuel < 0) return 0;

        if (dp[st][fuel] != -1)
            return dp[st][fuel];

        long ans = 0;

        if (st == fin)
            ans = 1;

        for (int j = 0; j < loc.length; j++) {

            if (j == st)
                continue;

            int cost = Math.abs(loc[st] - loc[j]);

            if (cost <= fuel) {
                ans += solve(loc, j, fin, fuel - cost);

                // Keep ans small
                ans %= MOD;
            }
        }

        return dp[st][fuel] = (int) ans;
    }

    public int countRoutes(int[] locations, int start, int finish, int fuel) {

        int n = locations.length;

        dp = new int[n][fuel + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(locations, start, finish, fuel);
    }
}


// Time Complexity -> O(n^2 * f) where n is the number of locations and f is the fuel

// Space Complexity -> O(n * f) for the dp array