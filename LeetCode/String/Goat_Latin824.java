// 824. Goat Latin

// Link -> https://leetcode.com/problems/goat-latin/description/

// Approach -> Simple Linear Scan
// 1. Split the sentence into words.
// 2. Create a suffix string "maa".
// 3. Iterate over the words and append the appropriate suffix to each word.
// 4. Return the modified sentence with the appended suffixes.


// Code ->
class Solution {
    public String toGoatLatin(String sentence) {

        String[] words = sentence.split(" ");
        String suffix = "maa";

        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            char ch = Character.toLowerCase(word.charAt(0));
            StringBuilder sb1 = new StringBuilder(word);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                sb1.append(suffix);
            else {
                char first = sb1.charAt(0);
                sb1.deleteCharAt(0);
                sb1.append(first);
                sb1.append(suffix);
            }
            sb.append(sb1).append(" ");
            suffix += "a";
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)