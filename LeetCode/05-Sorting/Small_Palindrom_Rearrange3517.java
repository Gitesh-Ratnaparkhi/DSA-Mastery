// 3517. Smallest Palindromic Rearrangement I

// class Solution {
//     public String smallestPalindrome(String s) {
        // int n = s.length();
        // int arr[] = new int[26];

        // for (char ch : s.toCharArray())
        //     arr[ch - 'a']++;

        // String hl = "";

        // for (int i = 0; i < 26; i++) {
        //     if (arr[i] > 0) {
        //         if (arr[i] % 2 == 0)
        //             hl += String.valueOf((char) ('a' + i)).repeat(arr[i] / 2);
        //         else
        //             hl += String.valueOf((char) ('a' + i)).repeat((arr[i] + 1) / 2);
        //     }
        // }
        // String ans = hl +
        //         (n % 2 == 0
        //                 ? new StringBuilder(hl).reverse().toString()
        //                 : new StringBuilder(hl).reverse().deleteCharAt(0).toString());

        // return ans;

//     }
// }


// This was my first attempt at solving the problem, but it was incorrect. In this test case, Input is "yey" and the Output is "eye" while the Expected output is "yey". The issue arises because the code does not correctly handle the arrangement of characters to form the smallest palindromic rearrangement.


// Corrected version of the code:

class Solution {
    public String smallestPalindrome(String s) {
    
        int n = s.length();
        int[] arr = new int[26];

        for (char ch : s.toCharArray())
            arr[ch - 'a']++;

        String hl = "";
        String mid = "";

        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {

                // first half
                hl += String.valueOf((char) ('a' + i)).repeat(arr[i] / 2);

                // middle character
                if (arr[i] % 2 == 1)
                    mid = String.valueOf((char) ('a' + i));
            }
        }

        return hl + mid + new StringBuilder(hl).reverse().toString();

    }
}