// 3123. Find Edges in Shortest Paths
// Link -> https://leetcode.com/problems/find-edges-in-shortest-paths/description/?envType=daily-question&envId=2026-07-26
// Approach -> DFS + dijkstra [Hard]

// Code ->
class Solution {

    private long[] dijkstra(int src, int n, ArrayList<int[]>[] adj) {

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[src] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        pq.offer(new long[] { 0, src });

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            long dis = curr[0];
            int node = (int) curr[1];

            if (dis > dist[node])
                continue;

            for (int[] edge : adj[node]) {

                int nextNode = edge[0];
                int weight = edge[1];

                long newDist = dis + weight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.offer(new long[] { newDist, nextNode });
                }
            }
        }

        return dist;
    }

    public boolean[] findAnswer(int n, int[][] edges) {

        ArrayList<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj[u].add(new int[] { v, wt });
            adj[v].add(new int[] { u, wt });
        }

        long[] fromStart = dijkstra(0, n, adj);
        long[] fromEnd = dijkstra(n - 1, n, adj);

        boolean[] ans = new boolean[edges.length];

        long shortest = fromStart[n - 1];

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            if (fromStart[u] != Long.MAX_VALUE &&
                    fromEnd[v] != Long.MAX_VALUE &&
                    fromStart[u] + w + fromEnd[v] == shortest) {

                ans[i] = true;
            }

            if (fromStart[v] != Long.MAX_VALUE &&
                    fromEnd[u] != Long.MAX_VALUE &&
                    fromStart[v] + w + fromEnd[u] == shortest) {

                ans[i] = true;
            }
        }

        return ans;
    }
}

// Time Complexity -> O((V + E) log V)
// Space Complexity -> O(V + E)