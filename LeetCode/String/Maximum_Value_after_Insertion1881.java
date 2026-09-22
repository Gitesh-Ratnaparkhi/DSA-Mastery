// 1881. Maximum Value after Insertion

// Link -> https://leetcode.com/problems/maximum-value-after-insertion/description/?envType=daily-question&envId=2026-07-26
// Levle -> Medium
// Approach -> Greedy
// Code ->
class Solution {
    public String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder();

        if (n.charAt(0) != '-') {
            for (int i = 0; i < n.length(); i++) {
                int num = n.charAt(i) - '0';

                if (num < x) {
                    sb.append(x);
                    sb.append(n.substring(i));
                    return sb.toString();
                }

                sb.append(n.charAt(i));
            }

            sb.append(x);
            return sb.toString();
        }

        sb.append('-');

        for (int i = 1; i < n.length(); i++) {
            int num = n.charAt(i) - '0';

            if (num > x) {
                sb.append(x);
                sb.append(n.substring(i));
                return sb.toString();
            }

            sb.append(n.charAt(i));
        }

        sb.append(x);
        return sb.toString();
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)