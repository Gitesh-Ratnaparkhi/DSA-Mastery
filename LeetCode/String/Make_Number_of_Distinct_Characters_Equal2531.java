// 2531. Make Number of Distinct Characters Equal

// Link : https://leetcode.com/problems/make-number-of-distinct-characters-equal/description/?envType=daily-question&envId=2026-07-26

// Approach -> Brute Force

// Code ->
class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] s1 = new int[26];
        int[] s2 = new int[26];

        for (char ch : word1.toCharArray()) s1[ch - 'a']++;
        for (char ch : word2.toCharArray()) s2[ch - 'a']++;

        int l1 = 0, l2 = 0;
        for (int i = 0; i < 26; i++) {
            if (s1[i] > 0) l1++;
            if (s2[i] > 0) l2++;
        }

        for (int i = 0; i < 26; i++) {
            if (s1[i] == 0) continue;

            for (int j = 0; j < 26; j++) {
                if (s2[j] == 0) continue;

                if (i == j) {
                    if (l1 == l2) return true;
                    continue;
                }

                int newL1 = l1;
                int newL2 = l2;

                if (s1[i] == 1) newL1--;
                if (s2[i] == 0) newL2++;

                if (s2[j] == 1) newL2--;
                if (s1[j] == 0) newL1++;

                if (newL1 == newL2) return true;
            }
        }

        return false;
    }
}

// Time Complexity -> O(M+N)
// Space Complexity -> O(1)