// 357. Count Numbers with Unique Digits.

// Link -> https://leetcode.com/problems/count-numbers-with-unique-digits/description/


// Approach -> Dynamic Programming
// Pattern ->
// 1. For n = 0, the only number is 0 itself, so the count is 1.
// 2. For n = 1, the numbers are 0 to 9, so the count is 10. which includes 0 and 1-digit numbers.
// 3. For n = 2, we can have 9 options for the first digit (1-9) and 9 options for the second digit (0-9 excluding the first digit), so the count is 9 * 9 = 81. Adding the counts from n=0 and n=1, we get a total of 10 + 81 = 91.
// 4. For n = 3, we can have 9 options for the first digit (1-9), 9 options for the second digit (0-9 excluding the first digit), and 8 options for the third digit (0-9 excluding the first two digits), so the count is 9 * 9 * 8 = 648. Adding the counts from n=0, n=1, and n=2, we get a total of 10 + 81 + 648 = 739.
// 5. This pattern continues for larger values of n, where the count for each n is calculated based on the counts from previous values of n and the number of unique digits available for each position in the number.

// Code ->

class Solution {

    private int fact(int i, int dp[]) {
        dp[i] = dp[i - 1] * (9 - (i - 2));
        return dp[i];
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int arr[] = new int[9];
        arr[0] = 1;
        int dp[] = new int[9];
        dp[0] = 1;
        dp[1] = 9;
        dp[2] = 81;

        arr[1] = arr[0] + dp[1];
        arr[2] = arr[1] + dp[2];
        for (int i = 3; i < arr.length; i++) {
            arr[i] = fact(i, dp) + arr[i - 1];
        }

        return arr[n];
    }
}


// Time Complexity: O(1)
// Space Complexity: O(1)