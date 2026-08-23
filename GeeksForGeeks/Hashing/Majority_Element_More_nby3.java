// Majority Element - More Than n/3

// Link -> https://www.geeksforgeeks.org/problems/majority-vote/1

// Approach -> HashMap [MEDIUM]
// Count the frequency of each element in the array and return the element with frequency greater than n/3.

// Code ->
class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        int n = arr.length;
        for (int i : arr)
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            if (e.getValue() > n / 3)
                ans.add(e.getKey());
        }
        Collections.sort(ans);
        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)