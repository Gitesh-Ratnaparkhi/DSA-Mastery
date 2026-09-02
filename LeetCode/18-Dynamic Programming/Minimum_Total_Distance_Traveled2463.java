// 2463. Minimum Total Distance Traveled
// Link -> https://leetcode.com/problems/minimum-total-distance-traveled/
// Approach -> Dynamic Programming [Hard]
// Code ->
class Solution {
    private static final long INF = 1_000_000_000_000_000L;

    private long solve(int i, int j, List<Integer> robot, List<Integer> pos, Long[][] memo) {
        if (i >= robot.size()) return 0;
        if (j >= pos.size()) return INF;

        if (memo[i][j] != null) return memo[i][j];

        long take = Math.abs((long) robot.get(i) - pos.get(j)) + solve(i + 1, j + 1, robot, pos, memo);
        long skip = solve(i, j + 1, robot, pos, memo);

        return memo[i][j] = Math.min(take, skip);
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        List<Integer> pos = new ArrayList<>();
        for (int[] f : factory) {
            int position = f[0];
            int limit = f[1];
            for (int k = 0; k < limit; k++) {
                pos.add(position);
            }
        }

        int m = robot.size();
        int n = pos.size();
        Long[][] memo = new Long[m][n];

        return solve(0, 0, robot, pos, memo);
    }
}

// Time Complexity -> O(m * n)
// Space Complexity -> O(m * n)