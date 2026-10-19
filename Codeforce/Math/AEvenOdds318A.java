// AEvenOdds
// Link -> https://codeforces.com/problemset/problem/318/A
// Level -> Easy;
// Approach -> Linear Search;
// Code ->

package Codeforce.Math;

import java.util.Scanner;

public class AEvenOdds318A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();

        long part = 0;
        if(n % 2 == 0) part =n / 2;
        else part = (n / 2) + 1;

        if(k <= part) System.out.print((k * 2)-1);
        else System.out.print((k - part) * 2);
    }
}

// Time Complexity -> O(1);
// Space Complexity -> O(1);