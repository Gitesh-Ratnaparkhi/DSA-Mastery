// 3945. Digit Frequency Score

// Link -> https://leetcode.com/problems/digit-frequency-score/description/

// Approach : Hash Map
// 1. We will use a HashMap to store the frequency of each digit in the given number n.
// 2. We will iterate through the digits of n and update the frequency in the HashMap.
// 3. Finally, we will calculate the digit frequency score by multiplying each digit by its frequency and summing them up.


// Code ->
class Solution {
    public int digitFrequencyScore(int n) {
        Map<Integer ,Integer> mp = new HashMap<>();
        while(n > 0){
            int i = n % 10;
            mp.put(i, mp.getOrDefault(i, 0) + 1);
            n /= 10;
        } 
        
        int ans = 0;
        for (Map.Entry<Integer, Integer> et : mp.entrySet()) {
            ans += et.getKey() * et.getValue();
        }
        return ans;
    }
}

// Time Complexity : O(log n)
// Space Complexity : O(1)



// Approach 2 : directly sum the digits of n

// Code ->