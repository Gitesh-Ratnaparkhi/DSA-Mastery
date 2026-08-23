// Find unique element

// Link -> https://www.geeksforgeeks.org/problems/find-unique-element2632/1

// Appraoch -> HashMap [EASY]
// Simply iterate through the array and check if the frequency of each element is divisible by k. If it is not, then return the element.

// Code ->
class Solution {
    public int uniqueElement(int[] arr, int k) {
        // code here
        Map<Integer , Integer> mp = new HashMap<>();
        for(int i : arr) mp.put(i, mp.getOrDefault(i, 0) + 1);
        
        int ans  = 0;
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) { 
            if(e.getValue() % k != 0) ans = e.getKey();
        }
        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)