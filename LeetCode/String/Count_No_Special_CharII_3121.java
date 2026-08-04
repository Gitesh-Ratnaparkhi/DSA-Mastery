// 3121. Count the Number of Special Characters II

// Link -> https://leetcode.com/problems/count-the-number-of-special-characters-in-a-string/description/

// Approach -> Brute Force

// 1. Create two arrays of size 26 to store the index of the last occurrence of each lowercase and uppercase character in the input string.
// 2. Iterate through the input string and update the index of the last occurrence of each character in the respective arrays.
// 3. Iterate through the array and check if the index of the last occurrence of each lowercase character is less than the index of the last occurrence of the corresponding uppercase character. If it is, increment the count of special characters.
// 4. Return the count of special characters.

// Code ->
class Solution {
    public int numberOfSpecialChars(String word) {
        int arr[] = new int[26];
        Arrays.fill(arr, -1);

        int arr2[] = new int[26];
        Arrays.fill(arr2, -1);

        int ans = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx;
            if (Character.isLowerCase(ch)) {
                idx = ch - 'a';
                arr[idx] = i;
            } else {
                idx = ch - 'A';
                if (arr2[idx] == -1)
                    arr2[idx] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] < arr2[i] && arr[i] != -1 && arr2[i] != -1)
                ans++;
        }

        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)

// Approach -> Optimized

// Code ->
class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                lastLower[ch - 'a'] = i + 1;
            } else {
                int idx = ch - 'A';
                if (firstUpper[idx] == 0) {
                    firstUpper[idx] = i + 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (lastLower[i] != 0 &&
                    firstUpper[i] != 0 &&
                    lastLower[i] < firstUpper[i]) {
                ans++;
            }
        }

        return ans;
    }
}