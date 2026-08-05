// 3310. Remove Methods From Project


// Link -> https://leetcode.com/problems/remove-methods-from-project/description/

// Approach -> DFS
// 1. Create a graph representation of the methods and their invocations using an adjacency list.
// 2. Use a boolean array to keep track of the suspected methods that can be removed.
// 3. Perform a depth-first search (DFS) starting from the method k to mark all reachable methods as suspected.
// 4. After the DFS, check each invocation to see if there is a method that is not suspected but invokes a suspected method. If such a method exists, return all methods as they cannot be removed.
// 5. If no such method exists, return the list of suspected methods that can be removed.



// Code ->
class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : invocations) graph[edge[0]].add(edge[1]);
        boolean[] sus = new boolean[n];
        Stack<Integer> st = new Stack<>();
        st.push(k);

        while (!st.isEmpty()) {
            int nd = st.pop();
            if (sus[nd]) continue;
            sus[nd] = true;
            for (int next : graph[nd]) {
                if (!sus[next]) st.push(next);
            }
        }

        for (int[] edge : invocations) {
            int from = edge[0];
            int to = edge[1];
            if (!sus[from] && sus[to]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) ans.add(i);
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!sus[i]) ans.add(i);
        }
        return ans;
    }
}


// Time Complexity -> O(n + m) where n is the number of methods and m is the number of invocations
// Space Complexity -> O(n + m) for the graph representation and the stack used in DFS