// 398. Random Pick Index

// Link -> https://leetcode.com/problems/random-pick-index/description/

// Approach -> Hash Map [Brute Force]
// 1. Create a HashMap of Integer and List<Integer> to store the indices of each number in the array.
// 2. Traverse the input array and for each number, add its index to the corresponding list in the HashMap.
// 3. In the pick() method, retrieve the list of indices for the target number
// 4. Generate a random index between 0 and the size of the list.
// 5. Return the index at the randomly generated index from the list of indices.


// Code ->
class Solution {

    Map<Integer , List<Integer>> mp;
    public Solution(int[] nums) {
        mp = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> li = mp.get(target);
        int n = li.size();
        int r_index = (int)(Math.random() * n);
        return li.get(r_index);
    }
}

// Time Complexity -> O(n) for constructor and O(1) for pick() method
// Space Complexity -> O(n)