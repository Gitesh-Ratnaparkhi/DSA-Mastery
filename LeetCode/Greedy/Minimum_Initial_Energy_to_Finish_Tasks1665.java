// 1665. Minimum Initial Energy to Finish Tasks
// Link -> https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/
// Level -> Hard
// Approach -> Greedy
// Code
class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        
        int m = tasks.length;
        int sum = 0;
        
        for (int i = 0; i < m; i++) {
            sum += tasks[i][0];
        }
        
        int ans = sum;
        
        for (int i = m - 1; i >= 0; i--) {
            int er = (sum - tasks[i][0]) + tasks[i][1];
            ans = Math.max(ans, er);
            sum -= tasks[i][0];
        }
        
        return ans;
    }
}

// Time Complexity -> O(nlogn)
// Space Complexity -> O(1)