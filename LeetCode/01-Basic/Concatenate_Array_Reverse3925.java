// 3925. Concatenate Array With Reverse


// Approach -> Simple Linear Scan
// The problem is solved using a simple linear scan of the input array. The algorithm iterates through the array and fills the first half of the result array with the original elements and the second half with the elements in reverse order. Finally, the result array is returned as the output.


// Code ->
class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int ans[] = new int[2 * n];
        int n2 = ans.length;
        n2-=1;
        for(int i=0; i<n; i++){
            ans[i] = nums[i];
            ans[n2-i] = nums[i];
        }
        return ans;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N * 2)