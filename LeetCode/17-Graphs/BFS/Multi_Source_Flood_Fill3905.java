// 3905. Multi Source Flood Fill
// Link -> https://leetcode.com/problems/multi-source-flood-fill/description/
// Approach -> BFS [Medium]
// Code ->
class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] ans = new int[n][m];
        
        for (int[] s : sources) {
            int r = s[0], c = s[1], color = s[2];
            ans[r][c] = Math.max(ans[r][c], color);
        }

        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (ans[r][c] != 0) {
                    q.offer(new int[]{r, c, ans[r][c]});
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            int size = q.size();
            Map<Integer, Integer> nextStep = new HashMap<>();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                int color = curr[2];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && ans[nr][nc] == 0) {
                        int key = nr * m + nc;
                        nextStep.put(key, Math.max(nextStep.getOrDefault(key, 0), color));
                    }
                }
            }

            for (Map.Entry<Integer, Integer> entry : nextStep.entrySet()) {
                int key = entry.getKey();
                int maxColor = entry.getValue();
                int r = key / m;
                int c = key % m;

                ans[r][c] = maxColor;
                q.offer(new int[]{r, c, maxColor});
            }
        }

        return ans;
    }
} 

// Time Complexity: O(n * m)
// Space Complexity: O(n * m)