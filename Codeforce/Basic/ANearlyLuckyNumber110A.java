// ANearlyLuckyNumber
// Link -> https://codeforces.com/problemset/problem/110/A
// Level -> Easy;
// Approach -> Linear Search;
// Code ->
package Codeforce.Basic;

import java.util.Scanner;

public class ANearlyLuckyNumber110A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        
        int luckyCount = 0;
        
        while (n > 0) {
            long digit = n % 10;
            if (digit == 4 || digit == 7) {
                luckyCount++;
            }
            n /= 10;
        }
        
        if (luckyCount == 4 || luckyCount == 7) System.out.println("YES");
        else System.out.println("NO");
    }
}

// Time Complexity -> O(n) where n is the input number;
// Space Complexity -> O(1);