// 1976. Number of Ways to Arrive at Destination

// Link -> https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

// Approach -> DFS


// Code ->
import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {

        Map<Integer, Long> mp = new HashMap<>();

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        dist[0] = 0;
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int node = curr[0];
            int dis = curr[1];

            if (dis > dist[node]) {
                continue;
            }

            if (node == n - 1) {
                mp.put(dis, mp.getOrDefault(dis, 0L) + 1);
            }

            for (int[] next : graph[node]) {

                int nb = next[0];
                int weight = next[1];

                int td = dis + weight;

                if (td <= dist[nb]) {

                    dist[nb] = td;

                    pq.offer(new int[]{
                        nb,
                        td
                    });
                }
            }
        }

        int MOD = 1000000007;
        int min = Integer.MAX_VALUE;
        long ans = 0;

        for (Map.Entry<Integer, Long> entry : mp.entrySet()) {

            if (entry.getKey() < min) {
                min = entry.getKey();
                ans = entry.getValue();
            }
        }

        return (int) (ans % MOD);
    }
}




// Approach 2 -> 


// Code ->
import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        long[] ways = new long[n];

        // Min-heap storing {node, distance}
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));

        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long d = curr[1];

            if (d > dist[u]) {
                continue;
            }

            for (int[] edge : graph[u]) {
                int v = edge[0];
                long w = edge[1];
                long newDist = d + w;

                // Found a strictly shorter path to v
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    pq.offer(new long[]{v, newDist});
                } 
                // Found an alternative path of the exact same shortest distance
                else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}