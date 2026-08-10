// 2359. Find Closest Node to Given Two Nodes

// Link: https://leetcode.com/problems/find-closest-node-to-given-two-nodes/description/

// Approach: DFS 
// 1. We can use depth-first search (DFS) to traverse the graph starting from both node1 and node2.
// 2. We will maintain two distance arrays, dis1 and dis2, to store the distances from node1 and node2 to all other nodes respectively.
// 3. We will calculate the maximum distance between the two nodes for each node using Math.max(dis1[node], dis2[node]).
// 4. We will update minMaxDist and resultNode if the current maximum distance is less than minMaxDist.

// Code ->

class Solution {

    private void dfs(int[] edges, int node, int[] dis, int val) {
        if (node == -1 || dis[node] != -1)
            return;

        dis[node] = val;
        dfs(edges, edges[node], dis, val + 1);
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dis1 = new int[n];
        int[] dis2 = new int[n];
        Arrays.fill(dis1, -1);
        Arrays.fill(dis2, -1);

        dfs(edges, node1, dis1, 0);
        dfs(edges, node2, dis2, 0);

        int minMaxDist = Integer.MAX_VALUE;
        int resultNode = -1;

        for (int i = 0; i < n; i++) {
            if (dis1[i] != -1 && dis2[i] != -1) {
                int currentMax = Math.max(dis1[i], dis2[i]);

                if (currentMax < minMaxDist) {
                    minMaxDist = currentMax;
                    resultNode = i;
                }
            }
        }

        return resultNode;
    }
}

// Time Complexity: O(n) - We traverse the graph twice (once for each node), and
// then we iterate through the distances array to find the closest meeting node.
// Space Complexity: O(n) - We use two distance arrays to store the distances
// from node1 and node2 to all other nodes.