// 833. Find And Replace in String
// Link -> https://leetcode.com/problems/find-and-replace-in-string/description/?envType=daily-question&envId=2026-07-26
// Approach -> Brute Force [Medium]
// Code -> 
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder(s);
        int n = indices.length;

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> Integer.compare(indices[b], indices[a]));

        for (int i = 0; i < n; i++) {
            int op = order[i];
            int idx = indices[op];
            String subs = sources[op];
            String tar = targets[op];

            if (s.startsWith(subs, idx)) {
                sb.replace(idx, idx + subs.length(), tar);
            }
        }

        return sb.toString();
    }
}

// Time Complexity -> O(nlogn)
// Space Complexity -> O(n)