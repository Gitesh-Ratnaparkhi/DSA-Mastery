// 3069. Distribute Elements Into Two Arrays I

// Link -> https://leetcode.com/problems/distribute-elements-into-two-arrays-i/description/?envType=daily-question&envId=2026-07-26

// Approach -> Brute Force
// 1. I have used a List to store the first array elements.
// 2. I have used a index variable to store the index of the first array.
// 3. Then simply traverse the array and check if the first array element is greater than the last element of the second array.
// 4. If it is greater, then add the element to the first array and increment the index.
// 5. Otherwise, add the element to the second array.
// 6. Return the first array.


// Code ->
class Solution {
    public int[] resultArray(int[] nums) {

        int n = nums.length;
        List<Integer> arr2 = new ArrayList<>();
        int ans[] = new int[n];

        ans[0] = nums[0];
        arr2.add(nums[1]);

        int idx = 1;
        for (int i = 2; i < n; i++) {
            if (ans[idx - 1] > arr2.get(arr2.size() - 1)) {
                ans[idx] = nums[i];
                idx++;
            } else
                arr2.add(nums[i]);
        }
        for (int i : arr2) {
            ans[idx] = i;
            idx++;
        }
        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)