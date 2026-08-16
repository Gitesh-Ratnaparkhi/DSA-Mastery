// 2065. Maximum Path Quality of a Graph


// Link -> https://leetcode.com/problems/maximum-path-quality-of-a-graph/description/?envType=daily-question&envId=2026-07-26


// Approach -> DFS + Backtracking
// 1. We can use depth-first search (DFS) to traverse the graph and find the maximum quality of a path.
// 2. We will maintain a visited array to keep track of the nodes that have already been visited.
// 3. For each unvisited node, we will perform a DFS to find the maximum quality of a path that starts from the current node.
// 4. We will update the maximum quality if the current path quality is greater than the current maximum quality.

// Code ->
class Solution {
    int n;
    int ans = 0;



    private void dfs(int curr, int score, int remtime, int val[], List<int[]>[] graph, boolean vis[]){
        boolean fvis = !vis[curr];

        if(fvis){
            vis[curr] = true;
            score+=val[curr];
        }

        if(curr == 0) ans = Math.max(ans , score);

        for (int[] edge : graph[curr]) {
            int next = edge[0];
            int time = edge[1];

            if(time <= remtime){
                dfs(next, score, remtime - time, val, graph, vis);
            }
        }
        if (fvis) vis[curr] = false;
    }


    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        n = values.length;
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            graph[u].add(new int[]{v, time}); 
            graph[v].add(new int[]{u, time});
        }

        boolean vis[] = new boolean[n];
        dfs(0, 0, maxTime, values, graph, vis);
        return ans;
    }
}

// Time Complexity -> O(4^T)
// Space Complexity -> O(n + T)