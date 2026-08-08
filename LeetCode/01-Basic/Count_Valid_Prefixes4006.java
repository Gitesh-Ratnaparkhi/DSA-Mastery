// 4006. Count Valid Prefixes


// Link -> https://leetcode.com/problems/count-valid-prefixes/description/

// Approach:
// 1. Initialize two counters, oc for counting occurrences of '1's and zec for counting occurrences of '0's.
// 2. Iterate through each character in the input string s.
// 3. If the current character is '1', increment the oc counter.
// 4. If the current character is '0', increment the zec counter.
// 5. After updating the counters, check if the absolute difference between oc and zec is either 0 or 1. If it is, increment the ans counter.
// 6. Return the final value of ans as the count of valid prefixes.

// A prefix is valid if the number of '1's and '0's in the prefix differ by at most 1 or 0.


// Code ->
class Solution {
    public int countValidPrefixes(String s) {
        int ans = 0;
        int oc = 0, zec = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1') oc++;
            else zec++;
            if(Math.abs(oc - zec) == 1 || Math.abs(oc - zec) == 0)ans++;
        }
        return ans;
    }
}

// Time Complexity: O(n) where n is the length of the input string s. We iterate through the string once to count valid prefixes.
// Space Complexity: O(1) as we are using a constant amount of extra space for counting occurrences of '1's and '0's.