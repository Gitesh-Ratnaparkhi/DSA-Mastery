// 2007. Find Original Array From Doubled Array
// Link -> https://leetcode.com/problems/find-original-array-from-doubled-array/
// Difficulty: Medium
// Approach: Hash Table
// Code :
class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[0];

        Arrays.sort(changed);

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : changed) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        int val = n / 2;
        int idx = 0;
        int ans[] = new int[n / 2];

        for (int i : changed) {
            if (mp.getOrDefault(i, 0) == 0) continue;

            if (i == 0) {
                if (mp.get(0) < 2) return new int[0];
                ans[idx++] = 0;
                val--;
                mp.put(0, mp.get(0) - 2);
            } 
            else if (mp.getOrDefault(i * 2, 0) > 0) {
                ans[idx++] = i;
                val--;

                if (mp.get(i) == 1) mp.remove(i);
                else mp.put(i, mp.get(i) - 1);

                if (mp.get(i * 2) == 1) mp.remove(i * 2);
                else mp.put(i * 2, mp.get(i * 2) - 1);
            } else {
                return new int[0];
            }

            if (val == 0) break;
        }

        if (val != 0) return new int[0];
        return ans;
    }
}

// Time Complexity: O(nlogn) + O(n) = O(nlogn)
// Space Complexity: O(n)