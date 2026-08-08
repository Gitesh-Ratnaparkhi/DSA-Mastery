// 1079. Letter Tile Possibilities

// Link: https://leetcode.com/problems/letter-tile-possibilities/description/

// Approach: Backtracking
// 1. Create a helper function that takes the input string tiles, a set to store unique permutations, a StringBuilder to build the current permutation, and a boolean array to track used characters.
// 2. In the helper function, iterate through each character in the tiles string.
// 3. If the character is already used, skip it.
// 4. Mark the character as used.
// 5. Append the character to the StringBuilder.
// 6. Add the current permutation to the set.
// 7. Recursively call the helper function with the remaining characters.
// 8. Remove the character from the StringBuilder.
// 9. Mark the character as not used.


// Code ->
class Solution {

    private void helper(String tiles, Set<String> st, StringBuilder sb, boolean[] used) {

        for (int i = 0; i < tiles.length(); i++) {
            if (used[i]) continue;
            
            used[i] = true;
            sb.append(tiles.charAt(i));
            st.add(sb.toString());
            helper(tiles, st, sb, used);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }

    public int numTilePossibilities(String tiles) {

        Set<String> st = new HashSet<>();

        boolean[] used = new boolean[tiles.length()];

        helper(tiles, st, new StringBuilder(), used);

        return st.size();
    }
}


// Time Complexity: O(n * n!) where n is the length of the input string tiles. The number of permutations of n elements is n!, and for each permutation, we may need to create a new string which takes O(n) time.
// Space Complexity: O(n) for the recursion stack and the used array, plus O(n * n!) for storing all unique permutations in the set.



// Approach:
// 1. Create a frequency array to count the occurrences of each character in the input string tiles.
// 2. Create a helper function that takes the frequency array as input and returns the count of unique permutations that can be formed using the characters in the frequency array.
// 3. In the helper function, iterate through each character in the frequency array.
// 4. If the frequency of the character is 0, skip it.
// 5. Decrement the frequency of the character.
// 6. Recursively call the helper function with the updated frequency array.
// 7. Increment the frequency of the character.


// Code ->
class Solution {
    private int helper(int[] freq) {
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;

            freq[i]--;
            count++;
            count += helper(freq);
            freq[i]++;
        }

        return count;
    }

    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];

        for (char ch : tiles.toCharArray()) {
            freq[ch - 'A']++;
        }

        return helper(freq);
    }
}


// Time Complexity: O(n!) where n is the length of the input string tiles. The number of permutations of n elements is n!.
// Space Complexity: O(n) for the recursion stack and the frequency array.