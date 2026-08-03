// 788. Rotated Digits 

// Approach: Brute Force
// Simply iterate through all the numbers from 1 to n and check if the number is valid or not. If it is valid, then increment the answer by 1.



// code solution
class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            int n1 = i;
            boolean flag = false;
            while (n1 > 0) {
                int k = n1 % 10;
                if (k == 3 || k == 4 || k == 7) {
                    flag = false;
                    break;
                }
                if (k == 2 || k == 5 || k == 6 || k == 9)
                    flag = true;

                n1 /= 10;
            }
            if (flag)
                ans++;
        }
        return ans;
    }
}


// Time Complexity: O(n log n)
// Space Complexity: O(1)