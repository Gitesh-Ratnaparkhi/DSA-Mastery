// 2577. Minimum Time to Visit a Cell In a Grid

// Link -> https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/description/

// Approach -> BFS [Dijkstra's Algorithm]




// Code ->
class Solution {

    int m, n;

    public int minimumTime(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        int[][] dis = new int[m][n];

        for (int x = 0; x < m; x++) Arrays.fill(dis[x], Integer.MAX_VALUE);

        dis[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.add(new int[]{0, 0, 0});

        if (m > 1 && n > 1 && grid[1][0] > 1 && grid[0][1] > 1) return -1;

        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int time = curr[0];
            int i = curr[1];
            int j = curr[2];

            if (time > dis[i][j]) continue;

            for (int[] dir : dirs) {

                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni < 0 || ni >= m ||
                    nj < 0 || nj >= n) {
                    continue;
                }

                int nextTime = time + 1;

                if (nextTime >= grid[ni][nj]) {

                    if (nextTime < dis[ni][nj]) {

                        dis[ni][nj] = nextTime;

                        pq.add(new int[]{
                            nextTime, ni, nj
                        });
                    }

                } else {

                    int diff = grid[ni][nj] - time;

                    if (diff % 2 != 0) nextTime = grid[ni][nj];
                    else nextTime = grid[ni][nj] + 1;

                    if (nextTime < dis[ni][nj]) {

                        dis[ni][nj] = nextTime;

                        pq.add(new int[]{
                            nextTime, ni, nj
                        });
                    }
                }
            }
        }

        return dis[m - 1][n - 1];
    }
}

// Time Complexity -> O(m × n × log(m × n)) where m is the number of rows and n is the number of columns
// Space Complexity -> O(m * n)