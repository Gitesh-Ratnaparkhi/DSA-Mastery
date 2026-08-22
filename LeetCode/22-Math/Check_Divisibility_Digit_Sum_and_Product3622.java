// 3622. Check Divisibility by Digit Sum and Product

// Link -> https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/?envType=daily-question&envId=2026-07-26

// Approach -> Math [EASY]
// 1. Calculate the sum and product of the digits of n.
// 2. Check if both the sum and product are divisible by t.
// 3. Return true if both the sum and product are divisible by t, otherwise return false.


// Code ->
class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, pro = 1;
        int temp = n;
        while(temp > 0){
            sum+=temp%10;
            pro*=temp%10;
            temp/=10;
        }
        return n % (sum + pro) == 0;
    }
}

// Time Complexity -> O(log n)
// Space Complexity -> O(1)