// BFS of graph


// Link -> https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

// Approach -> BFS [EASY]

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        int n = adj.size();
        boolean vis[] = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            if(vis[curr]) continue;
            
            vis[curr] = true;
            ans.add(curr);
            
            ArrayList<Integer> child = adj.get(curr);
            for(int i : child){
                if(!vis[i]) q.add(i);
            }
        }
        return ans;
    }
}

// Time Complexity: O(V+E)
// Space Complexity: O(V)
