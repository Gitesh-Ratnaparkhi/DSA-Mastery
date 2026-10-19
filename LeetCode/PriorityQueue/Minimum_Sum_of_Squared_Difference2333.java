// 2333. Minimum Sum of Squared Difference
// Link -> https://leetcode.com/problems/minimum-sum-of-squared-difference/description/
// Difficulty -> Medium
// Approach -> Priority Queue
// Code ->
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        PriorityQueue<Integer> mh = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<nums1.length; i++){
            int val = Math.abs(nums1[i] - nums2[i]);
            if(val != 0) mh.add(val);
        }

        int k = k1 + k2;
        while(k > 0 && !mh.isEmpty()){
            int val = mh.poll() - 1;
            if(val == 0) mh.remove(val);
            else mh.add(val);
            k--;
        }
        long ans = 0;
        while(!mh.isEmpty()){
            int val = mh.poll();
            ans += (val * val);
        }
        return ans;
    }
}

// This code will give TLE for large inputs, so we can use priority queue to solve this problem in O(NlogN) time complexity.
// Time Complexity -> O(NlogN)
// Space Complexity -> O(N)