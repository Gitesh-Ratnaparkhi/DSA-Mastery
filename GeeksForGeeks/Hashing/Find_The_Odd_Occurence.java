// Find The Odd Occurence
// Link : https://practice.geeksforgeeks.org/problems/find-the-odd-occurence/1?utm_source=gfg&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

// Approach : HashMap [EASY]
// Count the frequency of each element in the array and return the element with odd frequency

// Code ->
class Solution {
    // Method to find the element with odd occurrence in given array
    int getOddOccurrence(int[] arr) {
        // code here
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i : arr){
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            if(e.getValue() % 2 != 0){
                ans = e.getKey();
                break;
            }
        }
        return ans;
    }
}

// Time Complexity : O(N)
// Space Complexity : O(N)