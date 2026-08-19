// DFS of Graph

// Link -> https://practice.geeksforgeeks.org/problems/dfs-of-graph/1?utm_source=gfg&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

// Approach -> DFS [EASY]

// Code -> 
class Solution {

    public void solve(ArrayList<ArrayList<Integer>> adj, int curr, ArrayList<Integer> ans, boolean vis[]) {
        if (vis[curr])
            return;
        vis[curr] = true;
        ans.add(curr);

        ArrayList<Integer> child = adj.get(curr);

        for (int i : child) {
            solve(adj, i, ans, vis);
        }
    }

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = adj.size();
        boolean vis[] = new boolean[n];
        solve(adj, 0, ans, vis);
        return ans;

    }
}

// Time Complexity -> O(V+E)
// Space Complexity -> O(V)