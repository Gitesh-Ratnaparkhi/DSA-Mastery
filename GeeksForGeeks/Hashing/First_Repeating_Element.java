// First Repeating Element

// Link -> https://www.geeksforgeeks.org/problems/first-repeating-element4018/1

// Approach -> HashMap [EASY]
// Simply iterate through the array and check if the frequency of each element is greater than 1. If it is, then return the index of the element. Otherwise, return -1.

// Code ->
class Solution {
    public int firstRepeated(int[] arr) {

        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : arr) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (mp.get(arr[i]) > 1) {
                return i + 1;
            }
        }

        return -1;
    }
}

// Time Complexity -> O(N)
// Space Complexity -> O(N)