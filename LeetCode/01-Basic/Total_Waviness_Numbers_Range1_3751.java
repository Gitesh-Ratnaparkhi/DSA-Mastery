// 3751. Total Waviness of Numbers in Range I


// Link -> https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/description/


// Apptoach: Brute Force
// The idea is to iterate through all the numbers in the range [num1, num2] and for each number, check how many "waviness" points it has. A "waviness" point is defined as a digit that is either greater than both its neighbors or less than both its neighbors. We can convert the number to a string to easily access its digits and check the conditions for waviness. Finally, we sum up the waviness points for all numbers in the range and return the total.

// Code ->
class Solution {

    private int check(int num) {
        String s = String.valueOf(num);
        int ans = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i - 1) &&
                s.charAt(i) > s.charAt(i + 1)) {
                ans++;
            }

            if (s.charAt(i) < s.charAt(i - 1) &&
                s.charAt(i) < s.charAt(i + 1)) {
                ans++;
            }
        }

        return ans;
    }

    public int totalWaviness(int num1, int num2) {
        if (num2 < 100) return 0;

        int ans = 0;

        for (int i = num1; i <= num2; i++) {
            ans += check(i);
        }

        return ans;
    }
}






// Time Complexity: O(n * m) where n is the range of numbers and m is the average number of digits in the numbers.
// Space Complexity: O(1)