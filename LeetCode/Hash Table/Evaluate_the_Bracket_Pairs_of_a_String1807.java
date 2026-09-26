// 1807. Evaluate the Bracket Pairs of a String
// Link -> https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/description/
// Approach -> HashMap
// Code ->
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> mp = new HashMap<>();

        for (int i = 0; i < knowledge.size(); i++) {
            mp.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        int n = s.length();
        int st = 0;
        boolean stf = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st = i;
                stf = true;
            } else if (s.charAt(i) == ')') {
                String key = s.substring(st + 1, i);

                if (mp.containsKey(key)) sb.append(mp.get(key));
                else sb.append("?");

                stf = false;
            } else if (!stf)
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}

// Time complexity: O(n + m) where n is the length of the string s and m is the total number of characters in the knowledge list.
// Space complexity: O(m) where m is the total number of characters in the knowledge list.  
