// 67. Add Binary

// Link -> https://leetcode.com/problems/add-binary/


// Approach -> Brute Force
// The idea is to convert the binary strings to integers and then add them together. Finally, convert the sum back to a binary string.

// Code ->
class Solution {

    private String ans(String a, String b) {
        int al = a.length() - 1;
        int bl = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        // Process both strings
        while (bl >= 0) {

            int x = a.charAt(al) - '0';
            int y = b.charAt(bl) - '0';

            int sum = x + y + carry;

            sb.append(sum % 2);
            carry = sum / 2;

            al--;
            bl--;
        }

        // Process remaining bits of a
        while (al >= 0) {

            int x = a.charAt(al) - '0';

            int sum = x + carry;

            sb.append(sum % 2);
            carry = sum / 2;

            al--;
        }

        if (carry == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    public String addBinary(String a, String b) {
        if (a.length() >= b.length()) {
            return ans(a, b);
        }

        return ans(b, a);
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)