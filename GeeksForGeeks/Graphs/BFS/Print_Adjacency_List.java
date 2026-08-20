// Print Adjacentcy List

// Link -> https://practice.geeksforgeeks.org/problems/print-adjacency-list/1?utm_source=gfg&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

// Approach -> BFS [EASY]

// Code ->

class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        // code here
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}

// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V + E) for storing the graph and the recursion stack.