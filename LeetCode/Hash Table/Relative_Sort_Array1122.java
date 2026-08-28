// 1122. Relative Sort Array

// Link -> https://leetcode.com/problems/relative-sort-array/description/
// Approach -> Hash Map [Easy]
// Code->
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> mp = new TreeMap<>();
        int[] ans = new int[arr1.length];

        for (int i : arr1) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        int idx = 0;
        for (int i = 0; i < arr2.length; i++) {
            int num = arr2[i];
            int val = mp.get(num);
            while (val > 0) {
                ans[idx++] = num;
                val--;
            }
            mp.remove(num);
        }

        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            int num = e.getKey();
            int val = e.getValue();
            while (val > 0) {
                ans[idx++] = num;
                val--;
            }
        }

        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)
