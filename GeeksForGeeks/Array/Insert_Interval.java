// Insert Interval

// Link -> hhttps://www.geeksforgeeks.org/problems/insert-interval-1666733333/1
// Level -> Medium
// Approach -> Array
// Code ->
class Solution {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        int i = 0;
        ArrayList<int[]> ans = new ArrayList<>();
        int n = intervals.length;

        while (i < n) {
            if (intervals[i][1] < newInterval[0]) {
                ans.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                break;
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }

            i++;
        }

        ans.add(newInterval);

        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }

        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)