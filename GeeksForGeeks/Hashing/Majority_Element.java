// Majority Element
// Link: https://www.geeksforgeeks.org/problems/majority-element-1587115620/1
// Level: Easy
// Approach: HashMap + Array
// Code

class Solution {
    int majorityElement(int a[]) {
        // code here
        int n = a.length;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i : a) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> mpe : mp.entrySet()) {
            if (mpe.getValue() > n / 2) {
                return mpe.getKey();
            }
        }

        return -1;
    }
}

// Time Complexity: O(n) -> Traversing the array
// Space Complexity: O(n) -> HashMap