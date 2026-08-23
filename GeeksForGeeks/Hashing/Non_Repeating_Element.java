// Non-Repeating Element

// Link -> https://www.geeksforgeeks.org/problems/non-repeating-element3958/1

// Approach -> HashMap [EASY]
// Simply iterate through the array and check if the frequency of each element is 1. If it is, then return the element. Otherwise, return 0.

// Code ->
class Solution {
    public int firstNonRepeating(int[] arr) {
        // code here
        Map<Integer , Integer> mp = new HashMap<>();
        
        for(int i : arr){
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        for(int i : arr){
            if (mp.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }
}


// Time Complexity -> O(N)
// Space Complexity -> O(N)
