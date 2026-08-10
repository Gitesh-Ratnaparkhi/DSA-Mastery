// 2872. Maximum Number of K-Divisible Components


// Link -> https://leetcode.com/problems/maximum-number-of-k-divisible-components/description/?envType=problem-list-v2&envId=depth-first-search

// Approach: First Approach [Depth First Search]
// Traverse the tree using depth-first search (DFS) and calculate the sum of values for each subtree. If the sum of a subtree is divisible by k, we can consider that subtree as a valid component and increment our answer. We will return the sum of the current subtree to its parent node for further calculations.

// Code ->
class Solution {

    int ans = 0;

    private long dfs(int node, int parent, List<List<Integer>> graph, int[] values, int k) { 
        long sum = values[node]; 
        for (int neighbor : graph.get(node)) { 
            if (neighbor == parent) { 
                continue; 
            } 
            sum += dfs(neighbor, node, graph, values, k); 
        } 
        if (sum % k == 0){
            ans++; 
            return 0;
        } 
        return sum; 
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, -1, graph, values, k); 
        return ans;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
