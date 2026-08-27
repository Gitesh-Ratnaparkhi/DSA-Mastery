// 3720. Lexicographically Smallest Permutation Greater Than Target
// Link -> https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/description/?envType=daily-question&envId=2026-08-18
// Approach -> HashMap [Medium]
// Code ->
class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) freq[ch - 'a']++;

        int match = 0;
        while (match < n) {
            int idx = target.charAt(match) - 'a';
            if (freq[idx] > 0) {
                freq[idx]--;
                match++;
            } else {
                break;
            }
        }

        for (int i = match; i >= 0; i--) {
            if (i < n) {
                int targetIdx = target.charAt(i) - 'a';
                for (int j = targetIdx + 1; j < 26; j++) {
                    if (freq[j] > 0) {
                        freq[j]--;

                        StringBuilder res = new StringBuilder();
                        res.append(target, 0, i);
                        res.append((char) ('a' + j));

                        for (int k = 0; k < 26; k++) {
                            while (freq[k] > 0) {
                                res.append((char) ('a' + k));
                                freq[k]--;
                            }
                        }
                        return res.toString();
                    }
                }
            }

            if (i > 0) {
                freq[target.charAt(i - 1) - 'a']++;
            }
        }

        return "";
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)