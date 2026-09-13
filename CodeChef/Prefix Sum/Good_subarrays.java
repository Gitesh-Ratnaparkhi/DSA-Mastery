// Good subarrays
// Link -> https://www.codechef.com/practice/course/arrays-strings-advanced/ARRAYSP06/problems/PREFPRO3
// Approach -> Prefix Sum
// Code ->
class Solution {
    public int countSubarraysWithSumK(List<Integer> ar, int k) {
        // write your code here 
         HashMap<Integer, Integer> mp = new HashMap<>();

        int sum = 0;
        int ans = 0;

        mp.put(0, 1);

        for (int i = 0; i < ar.size(); i++) {
            sum += ar.get(i);

            if (mp.containsKey(sum - k)) {
                ans += mp.get(sum - k);
            }

            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)