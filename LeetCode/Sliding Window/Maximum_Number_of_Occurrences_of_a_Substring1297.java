// 1297. Maximum Number of Occurrences of a Substring
// Link -> https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/description/?envType=daily-question&envId=2026-07-26
// Approach -> Sliding Window  [Medium]
// Code ->
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        Map<String, Integer> mp = new HashMap<>();
        int[] ch = new int[26];
        int uniqueLetters = 0;
        int maxCount = 0;

        for (int j = 0; j < n; j++) {
            if (ch[s.charAt(j) - 'a'] == 0) {
                uniqueLetters++;
            }
            ch[s.charAt(j) - 'a']++;

            if (j >= minSize) {
                char leftChar = s.charAt(j - minSize);
                ch[leftChar - 'a']--;
                if (ch[leftChar - 'a'] == 0) {
                    uniqueLetters--;
                }
            }

            if (j >= minSize - 1) {
                if (uniqueLetters <= maxLetters) {
                    String sub = s.substring(j - minSize + 1, j + 1);
                    int count = mp.getOrDefault(sub, 0) + 1;
                    mp.put(sub, count);
                    maxCount = Math.max(maxCount, count);
                }
            }
        }

        return maxCount;
    }
}

// Time Complexity -> O(N)
// Space Complexity -> O(N)