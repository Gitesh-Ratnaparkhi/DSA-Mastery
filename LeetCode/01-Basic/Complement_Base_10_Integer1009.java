// 1009. Complement of Base 10 Integer

// Link -> https://leetcode.com/problems/complement-of-base-10-integer/


// Apprach -> Brute Force
// The idea is to convert the number to its binary representation and then convert it to a string, and then flip all the bits in the binary representation. Finally, convert the binary representation back to a decimal number.


// code ->
class Solution {
    public int bitwiseComplement(int n) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '0') sb.setCharAt(i, '1');
            else sb.setCharAt(i, '0');
        }
        return Integer.parseInt(sb.toString() , 2);

    }
}


// Time Complexity -> O(log n) where n is the number of digits in the binary representation of the number
// Space Complexity -> O(log n) where n is the number of digits in the binary representation of the number




// Approach -> Bit Manipulation
// The idea is to create a mask that has the same number of bits as n, and then use the XOR operator to flip all the bits in n. Finally, return the result of the XOR operation.



// Code ->
class Solution {
    public int bitwiseComplement(int n) {
        /*
         * Binary representation of 0 is "0",
         * and its complement is "1".
         */
        if (n == 0) {
            return 1;
        }

        int mask = 0;
        int value = n;

        /*
         * Create a mask containing the same number of bits as n.
         *
         * Example:
         * n = 5     -> 101
         * mask      -> 111
         */
        while (value > 0) {
            mask = (mask << 1) | 1;
            value >>= 1;
        }

        return n ^ mask;
    }
}

// Time Complexity -> O(log n) where n is the number of digits in the binary representation of the number
// Space Complexity -> O(1)
