// 3341. Find Minimum Time to Reach Last Room I

// Link -> https://leetcode.com/problems/find-minimum-time-to-reach-last-room/description/

// Approach -> BFS

// 1. Initialize a queue to store the rooms and their arrival time.
// 2. Add the first room to the queue with arrival time 0.
// 3. While the queue is not empty, remove the first room from the queue and check if it is the last room.
// 4. If it is not the last room, add its neighbors to the queue with arrival time equal to the current arrival time plus the time required to reach the neighbor.
// 5. Return the arrival time of the last room.


// Code ->
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;

        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        dis[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, 0, 0});

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int i = curr[1];
            int j = curr[2];

            if (time != dis[i][j]) continue;
            if (i == m - 1 && j == n - 1) return time;

            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni < 0 || ni >= m || nj < 0 || nj >= n) continue;

                int nextTime = Math.max(time, moveTime[ni][nj]) + 1;

                if (nextTime < dis[ni][nj]) {
                    dis[ni][nj] = nextTime;
                    pq.add(new int[]{nextTime, ni, nj});
                }
            }
        }

        return -1;
    }
}

// Time Complexity -> O(m × n × log(m × n))
// Space Complexity -> O(m × n)