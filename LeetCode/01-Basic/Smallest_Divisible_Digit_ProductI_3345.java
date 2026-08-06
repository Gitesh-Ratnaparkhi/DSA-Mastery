// 3345. Smallest Divisible Digit Product I

// Link -> https://leetcode.com/problems/smallest-divisible-digit-product-i/?envType=daily-question&envId=2026-07-26

// Approach -> Brute Force
// 1. Start from the number n and iterate through all numbers greater than or equal to n.
// 2. For each number, calculate the product of its digits.
// 3. Check if the product is divisible by t.
// 4. If it is divisible, return the number.


// Code ->
class Solution {
    public int smallestNumber(int n, int t) {
        int lim = n + 10;
        int ans = 0;
        for(int i=n; i<lim; i++){
            int num = i;
            int pro = 1;
            while(num > 0){
                pro *= num % 10;
                num /=  10;
            }
            if(pro % t == 0){
                ans = i;
                break;
            }
        }
        return ans;
    }
}

// Time Complexity -> O(n * d) where n is the number of digits and d is the number of digits in the number
// Space Complexity -> O(1)