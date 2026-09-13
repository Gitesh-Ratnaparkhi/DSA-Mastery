// Overlapping Intervals
// Link -> https://www.geeksforgeeks.org/problems/overlapping-intervals--170633/1
// Level -> Medium
// Approch -> Sorting
// Code ->
class Solution {
    public ArrayList<ArrayList<Integer>> mergeOverlap(int[][] arr) {
        // Code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int n = arr.length;
        int idx = 0;

        while (idx < n) {
            int st = arr[idx][0];
            int ed = arr[idx][1];
            int j = idx + 1;

            while (j < n && arr[j][0] <= ed) {
                ed = Math.max(ed, arr[j][1]);
                j++;
            }

            ArrayList<Integer> sub = new ArrayList<>();
            sub.add(st);
            sub.add(ed);
            ans.add(sub);

            idx = j;
        }
        return ans;
    }
}

// Time Complexity -> O(n log n)
// Space Complexity -> O(n)