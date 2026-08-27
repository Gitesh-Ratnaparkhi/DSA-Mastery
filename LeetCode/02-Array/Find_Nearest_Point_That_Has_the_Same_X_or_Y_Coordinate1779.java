// 1779. Find Nearest Point That Has the Same X or Y Coordinate
// Link : https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/description/?envType=daily-question&envId=2026-08-15
// Approach -> Brute Force [Easy]
// Code
class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDistance = Integer.MAX_VALUE;
        int idx = -1;

        for (int i = 0; i < points.length; i++) {
            if (x == points[i][0] || y == points[i][1]) {
                int distance = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);

                if (distance < minDistance) {
                    minDistance = distance;
                    idx = i;
                }
            }
        }

        return idx;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)