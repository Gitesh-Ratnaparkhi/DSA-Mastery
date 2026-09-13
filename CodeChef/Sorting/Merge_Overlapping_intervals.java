// Merge Overlapping intervals
// Link -> https://www.codechef.com/practice/course/arrays-strings-advanced/ARRAYSP06/problems/MERGEINTER
// Level -> Easy
// Topic -> Sorting
// Code ->
class Solution {
    public List<List<Integer>> merge(List<List<Integer>> intervals) {
        // write your code here 
        List<List<Integer>> ans = new ArrayList<>();

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

            List<Integer> sub = new ArrayList<>();
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