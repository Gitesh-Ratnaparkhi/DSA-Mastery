// Subarrays with Sum K
// Link -> https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1
// Level -> Medium
// Approach -> Brute Force
// Code ->
class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // code here
        int ans = 0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += arr[j];
                if(sum == k) ans++;
            }
        }
        return ans;
    }
}
// Time Complexity -> O(n^2)
// Space Complexity -> O(1)


// Approach 2 -> Prefix Sum
// Code ->
class Solution {
    public int cntSubarrays(int[] arr, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int sum = 0;
        int ans = 0;

        mp.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

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