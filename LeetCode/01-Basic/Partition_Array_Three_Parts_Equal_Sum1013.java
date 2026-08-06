// 1013. Partition Array Into Three Parts With Equal Sum

// Link: -> https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/description/

// Code ->
class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i : arr) sum += i;

        if (sum % 3 != 0) return false;

        int tar = sum / 3;
        int curr = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];

            if (curr == tar) {
                count++;
                curr = 0;
                if (count == 2 && i < arr.length - 1) return true;
            }
        }

        return false;
    }
}    

// Time Complexity -> O(n) where n is the number of elements in the array
// Space Complexity -> O(1)