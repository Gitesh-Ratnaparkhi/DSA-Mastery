// 3731. Find Missing Elements


// Link -> https://leetcode.com/problems/find-missing-elements/description/

// Approach -> Brute Force
// 1. Create a temporary array of size 101 to store the elements of the input array.
// 2. Find the minimum and maximum element in the input array.
// 3. Iterate from the minimum element to the maximum element, and add the missing elements to the result array.
// 4. Return the result array.

// Code ->
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        int temp[] = new int[101];
        int min = Integer.MAX_VALUE , max = 0;
        for(int i : nums){
            temp[i] = i;
            min = Math.min(min , i);
            max = Math.max(max , i);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = min; i<= max; i++){
            if(temp [i] == 0) ans.add(i);
        }
        return ans;
    }
}


// Time Complexity -> O(n)

// Space Complexity -> O(1)