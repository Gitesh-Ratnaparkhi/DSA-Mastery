// 1192. Critical Connections in a Network

// Link -> https://leetcode.com/problems/critical-connections-in-a-network/description/

// Approach -> Tarjan's Algorithm [Depth First Search]


// Tarjan's algorithm explanation:
// 


// Code ->
class Solution {
    int timer = 0;

    private void dfs(int node, int parent, List<List<Integer>> graph, int[] discovery, int[] low, List<List<Integer>> bridges) {

        discovery[node] = low[node] = timer++;

        for (int neighbor : graph.get(node)) {

            if (neighbor == parent) {
                continue;
            }

            if (discovery[neighbor] == -1) {

                dfs(neighbor, node, graph, discovery, low, bridges);

                low[node] = Math.min(low[node], low[neighbor]);

                if (low[neighbor] > discovery[node]) {
                    bridges.add(Arrays.asList(node, neighbor));
                }

            } else {

                low[node] = Math.min(low[node], discovery[neighbor]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] discovery = new int[n];
        int[] low = new int[n];

        Arrays.fill(discovery, -1);

        List<List<Integer>> bridges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (discovery[i] == -1) {
                dfs(i, -1, graph, discovery, low, bridges);
            }
        }

        return bridges;
    }
}


// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V + E) for storing the graph and the recursion stack.



// Dry Run ->
