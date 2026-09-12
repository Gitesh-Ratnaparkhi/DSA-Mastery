// 1636. Sort Array by Increasing Frequency
// Link -> https://leetcode.com/problems/sort-array-by-increasing-frequency/description/
// Level -> Easy
// Approach -> Sorting
// Code ->
class Solution {
    public int[] frequencySort(int[] nums) {
        int arr[][] = new int[201][2];

        for (int i : nums) {
            int index = i + 100;
            arr[index][0] = i;
            arr[index][1]++;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(b[0], a[0]);
        });

        int idx = 0;
        for (int i = 0; i < 201; i++) {
            if (arr[i][1] > 0) {
                int frequency = arr[i][1];
                int value = arr[i][0];
                
                while (frequency > 0) {
                    nums[idx++] = value;
                    frequency--;
                }
            }
        }
        return nums;
    }
}

// Time Complexity: O(n log n) - The sorting step dominates the time complexity, where n is the number of unique elements in the input array.
// Space Complexity: O(n) - We use an additional array to store the frequency of each element, where n is the number of unique elements in the input array.