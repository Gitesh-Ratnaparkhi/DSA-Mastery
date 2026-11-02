// 2326. Spiral Matrix IV
// Link -> https://leetcode.com/problems/spiral-matrix-iv/description/
// Level -> Medium
// Approach -> Simulation
// Code ->


class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int ans[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], -1);
        }

        int tp = 0;
        int bot = m - 1;
        int le = 0;
        int ri = n - 1;

        while (head != null) {
            for (int i = le; i <= ri && head != null; i++) {
                ans[tp][i] = head.val;
                head = head.next;
            }
            tp++;

            for (int i = tp; i <= bot && head != null; i++) {
                ans[i][ri] = head.val;
                head = head.next;
            }
            ri--; 

            if (tp <= bot && head != null) {
                for (int i = ri; i >= le && head != null; i--) {
                    ans[bot][i] = head.val;
                    head = head.next;               
                }
                bot--;
            }

            if (le <= ri && head != null) {
                for (int i = bot; i >= tp && head != null; i--) {
                    ans[i][le] = head.val;
                    head = head.next; 
                }
                le++;
            }
        }
        return ans;
    }
}

// Time Complexity -> O(m*n)
// Space Complexity -> O(m*n)