// Odd One Out
// Link -> https://codeforces.com/problemset/problem/1915/A
// Level -> Easy;
// Approach -> Linear Search;
// Code ->

package Codeforce.Basic;

import java.util.Scanner;

public class AOddOneOut1915A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == b)
                System.out.println(c);
            else if (a == c)
                System.out.println(b);
            else
                System.out.println(a);
        }
    }
}

// Time Complexity -> O(n) where n is the number of test cases;
// Space Complexity -> O(1);