// 3079. Find the Sum of Encrypted Integers

// Link -> https://leetcode.com/problems/find-the-sum-of-encrypted-integers/description/

// Approach: Brute Force
// 1. Initialize a variable ans to store the sum of encrypted integers.
// 2. Iterate through each integer in the input array nums.
// 3. For each integer, check if it is less than 10. If it is, add it to ans and continue to the next integer.
// 4. If the integer is greater than or equal to 10, find the maximum digit in the integer by repeatedly extracting the last digit and comparing it with the current maximum.
// 5. Depending on the number of digits in the integer, calculate the encrypted value and add it to ans.
// 6. Return the final sum of encrypted integers.


// Code ->
class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 10){
                ans+=nums[i];
                continue;
            }
            int n = nums[i];
            int max = 0;
            while(n > 0){
                max = Math.max(max , n % 10);
                n/=10;
            }
            if(nums[i] < 100) ans += 11 * max;
            else if(nums[i] == 1000) ans+= 1111;
            else ans += 111 * max;
        }
        return ans;
    }
}

// Time Complexity: O(n * d) where n is the length of the input array nums and d is the number of digits in the largest number in nums. We iterate through each number in nums and for each number, we may need to extract its digits which takes O(d) time.
// Space Complexity: O(1) as we are using a constant amount of extra space for variables like ans, n, and max.