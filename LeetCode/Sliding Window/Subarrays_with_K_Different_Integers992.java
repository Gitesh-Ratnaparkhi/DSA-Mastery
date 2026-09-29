// 992. Subarrays with K Different Integers
// Link -> https://leetcode.com/problems/subarrays-with-k-different-integers/
// Level -> Hard
// Approach -> Brute Force, Sliding Window, HashMap
// Code ->
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            Map<Integer, Integer> mp = new HashMap<>();
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            if(mp.size() == k)ans++;
            for(int j=i+1; j<n; j++){
                mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
                if(mp.size() == k) ans++;
            }
        }
        return ans;
    }
}

// This code will give TLE for large inputs, so we can use sliding window approach to solve this problem in O(n) time complexity.

// Time Complexity -> O(n^2)
// Space Complexity -> O(n)


// Approach 2 -> Modified Sliding Window Approach
// Code ->
class Solution {

    private int slide(int nums[], int k){
        int i=0;
        int j=0;
        int n=nums.length;
        int ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        while(j < n){
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            while(mp.size() > k){
                mp.put(nums[i], mp.getOrDefault(nums[i], 0) -1);
                if(mp.get(nums[i]) == 0) mp.remove(nums[i]);
                i++;
            }
            ans += (j-i+1);
            j++;
        }
        return ans;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return slide(nums, k) - slide(nums, k-1);
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)