// 395. Longest Substring with At Least K Repeating Characters


// Links: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/?envType=study-plan-v2&envId=leetcode-75

// Approach: Sliding Window
// 1. We can use a sliding window approach to find the longest substring with at least k repeating characters.
// 2. We will use a HashMap to store the frequency of each character in the current window.
// 3. We will use two pointers i and j to represent the start and end of the window.
// 4. We will increment i until the frequency of nums[i] is less than k.
// 5. We will increment j until the frequency of nums[j] is greater than or equal to k.
// 6. We will update the maximum length of the substring with at least k repeating characters.


// Code ->
class Solution {
    public int longestSubstring(String s, int k) {
        int ans = 0;

        for (int target = 1; target <= 26; target++) {

            int[] freq = new int[26];

            int i = 0;
            int j = 0;

            int unique = 0;
            int atLeastK = 0;

            while (i < s.length()) {

                int idx = s.charAt(i) - 'a';

                if (freq[idx] == 0) {
                    unique++;
                }

                freq[idx]++;

                if (freq[idx] == k) {
                    atLeastK++;
                }

                i++;

                while (unique > target) {

                    int left = s.charAt(j) - 'a';

                    if (freq[left] == k) {
                        atLeastK--;
                    }

                    freq[left]--;

                    if (freq[left] == 0) {
                        unique--;
                    }

                    j++;
                }

                if (unique == target && unique == atLeastK) {
                    ans = Math.max(ans, i - j);
                }
            }
        }

        return ans;
    }
}

// Time Complexity: O(26 * n) ~ O(n)
// Space Complexity: O(26) ~ O(1)