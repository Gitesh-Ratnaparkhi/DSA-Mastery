// 1928. Minimum Cost to Reach Destination in Time

// Link -> https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/description/

// Approach -> BFS [Dijkstra's Algorithm]


// Code ->
import java.util.*;

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {

        int n = passingFees.length;

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int t = e[2];

            graph[u].add(new int[]{v, t});
            graph[v].add(new int[]{u, t});
        }

        int[][] dist = new int[n][maxTime + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );

        dist[0][0] = passingFees[0];
        pq.offer(new int[]{passingFees[0], 0, 0});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int cost = cur[0];
            int city = cur[1];
            int time = cur[2];

            if (cost != dist[city][time]) {
                continue;
            }

            if (city == n - 1) {
                return cost;
            }

            for (int[] edge : graph[city]) {

                int next = edge[0];
                int travelTime = edge[1];

                int newTime = time + travelTime;

                if (newTime > maxTime) {
                    continue;
                }

                int newCost = cost + passingFees[next];

                if (newCost >= dist[next][newTime]) {
                    continue;
                }

                dist[next][newTime] = newCost;

                pq.offer(new int[]{
                    newCost,
                    next,
                    newTime
                });
            }
        }

        return -1;
    }
}

// Time Complexity -> O(m × n × log(m × n))
// Space Complexity -> O(m × n)


// Approach2 ->Optimized Dijkstra's Algorithm


// Code ->
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;

        // 1. Forward Star adjacency list representation (no List/Object overhead)
        int[] head = new int[n];
        Arrays.fill(head, -1);

        int m = edges.length;
        int edgeCount = m * 2;
        int[] to = new int[edgeCount];
        int[] timeEdge = new int[edgeCount];
        int[] nextEdge = new int[edgeCount];

        int eIdx = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1], t = e[2];
            if (t > maxTime) continue;

            to[eIdx] = v;
            timeEdge[eIdx] = t;
            nextEdge[eIdx] = head[u];
            head[u] = eIdx++;

            to[eIdx] = u;
            timeEdge[eIdx] = t;
            nextEdge[eIdx] = head[v];
            head[v] = eIdx++;
        }

        // 2. minTime[i] records the minimum time taken so far by any POPPED state for city i
        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        // Priority queue sorted by cost: [cost, city, time]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{passingFees[0], 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int u = cur[1];
            int time = cur[2];

            if (u == n - 1) {
                return cost;
            }

            // If an earlier (cheaper) state reached 'u' in less or equal time, discard this state
            if (time >= minTime[u]) {
                continue;
            }
            // Update minTime only upon POPPING (guaranteed to be monotonically non-decreasing in cost)
            minTime[u] = time;

            for (int e = head[u]; e != -1; e = nextEdge[e]) {
                int v = to[e];
                int nextTime = time + timeEdge[e];

                if (nextTime <= maxTime && nextTime < minTime[v]) {
                    pq.offer(new int[]{cost + passingFees[v], v, nextTime});
                }
            }
        }

        return -1;
    }
}


// Time Complexity -> O(m × n)
// Space Complexity -> O(m × n)


// Approach3 -> DP
// Code ->
import java.util.Arrays;

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        int INF = 0x3f3f3f3f;

        // dp[t][i]: minimum fee to reach city i in exactly t minutes
        int[][] dp = new int[maxTime + 1][n];
        for (int i = 0; i <= maxTime; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = passingFees[0];

        for (int t = 1; t <= maxTime; t++) {
            for (int[] e : edges) {
                int u = e[0], v = e[1], time = e[2];
                if (t >= time) {
                    if (dp[t - time][u] != INF) {
                        dp[t][v] = Math.min(dp[t][v], dp[t - time][u] + passingFees[v]);
                    }
                    if (dp[t - time][v] != INF) {
                        dp[t][u] = Math.min(dp[t][u], dp[t - time][v] + passingFees[u]);
                    }
                }
            }
        }

        int minCost = INF;
        for (int t = 0; t <= maxTime; t++) {
            minCost = Math.min(minCost, dp[t][n - 1]);
        }

        return minCost == INF ? -1 : minCost;
    }
}

// Time Complexity -> O(m × n)
// Space Complexity -> O(m × n)