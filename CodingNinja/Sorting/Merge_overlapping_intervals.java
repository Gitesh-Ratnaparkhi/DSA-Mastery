// Merge overlapping intervals
// Link -> https://www.naukri.com/code360/problems/merge-overlapping-intervals_1082151
// Level -> Easy
// Topic -> Sorting
// Code ->


public class Merge_overlapping_intervals {
	public ArrayList<ArrayList<Integer>> mergeIntervals(ArrayList<ArrayList<Integer>> intervals) {
	        // WRITE YOUR CODE HERE
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        intervals.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));

        int n = intervals.size();
        int idx = 0;

        while (idx < n) {
            int st = intervals.get(idx).get(0);
            int ed = intervals.get(idx).get(1);

            int j = idx + 1;

            while (j < n && intervals.get(j).get(0) <= ed) {
                ed = Math.max(ed, intervals.get(j).get(1));
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
