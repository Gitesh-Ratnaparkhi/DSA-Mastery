// 934. Shortest Bridge


// Link -> https://leetcode.com/problems/shortest-bridge/description/?envType=study-plan-v2&envId=leetcode-75


// Approach -> BFS + DFS
// 1. Find the first island in the grid.
// 2. Use DFS to mark all the cells of the first island and add them to a queue.
// 3. Use BFS to find the shortest path from the first island to the second island.
// 4. Return the shortest path found.

// Code:
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int m, n;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void dfs(int i, int j, int[][] grid, Queue<int[]> q) {
        if (i >= m || i < 0 || j < 0 || j >= n || grid[i][j] != 1) return;
        
        grid[i][j] = 2;
        q.add(new int[]{i, j});
        
        dfs(i + 1, j, grid, q);
        dfs(i, j + 1, grid, q);
        dfs(i - 1, j, grid, q);
        dfs(i, j - 1, grid, q);
    }

    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        outerloop:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, q);
                    break outerloop;
                }
            }
        }

        int distance = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        if (grid[nr][nc] == 1) {
                            return distance;
                        }
                        
                        if (grid[nr][nc] == 0) {
                            grid[nr][nc] = 2;
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }
            distance++;
        }

        return distance;
    }
}


// Time Complexity: O(m * n) - In the worst case, we may need to traverse the entire grid to find the first island and then perform a BFS to find the shortest bridge.
// Space Complexity: O(m * n) - The queue used for BFS can hold all the cells in the grid in the worst case.