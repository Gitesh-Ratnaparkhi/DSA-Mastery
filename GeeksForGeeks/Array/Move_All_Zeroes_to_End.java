// Move All Zeroes to End
// Link -> https://www.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1
// Level -> Easy
// Topic -> Array
// Code ->
class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        int n = arr.length;
        int i = 0, j = 0;

        while (j < n) {
            if (arr[j] != 0) {
                arr[i] = arr[j];

                if (i != j) {
                    arr[j] = 0;
                }

                i++;
            }
            j++;
        }

    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)