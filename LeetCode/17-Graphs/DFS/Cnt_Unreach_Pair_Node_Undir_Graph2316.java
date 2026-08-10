// 2316. Count Unreachable Pairs of Nodes in an Undirected Graph

// Link : https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/

// Approach : DFS
// 1. We can use depth-first search (DFS) to traverse the graph and find the size of each connected component.
// 2. We will maintain a visited array to keep track of the nodes that have already been visited.
// 3. For each unvisited node, we will perform a DFS to find the size of the connected component it belongs to and store the sizes in a list.
// 4. Finally, we will calculate the number of unreachable pairs of nodes by iterating through the sizes of the connected components and using the formula: size * (remaining - size), where remaining is the total number of nodes minus the sum of sizes of the previously counted components.



// Code ->
class Solution {

    private int dfs(int i, List<List<Integer>> adj, boolean vis[]) {
        vis[i] = true;
        int val = 1; 

        for (int n : adj.get(i)) {
            if (!vis[n]) {
                val += dfs(n, adj, vis); 
            }
        }
        return val;
    }

    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
    
            adj.get(u).add(v); 
            adj.get(v).add(u); 
        }

        boolean vis[] = new boolean[n];
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(vis[i]) continue;
            int node = dfs(i, adj, vis);
            ans.add(node);
        }

        if(ans.size() == 1) return 0;

        long ans1 = 0;
        long remaining = n;

        for(int i = 0; i < ans.size(); i++) {
            long size = ans.get(i);
            ans1 += size * (remaining - size);
            remaining -= size;
        }

        return ans1;
    }
}

// Time Complexity : O(n + e) where n is the number of nodes and e is the number of edges
// Space Complexity : O(n + e) for adjacency list and O(n) for visited array
