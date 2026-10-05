// AWordCapitalization
// Link -> https://codeforces.com/problemset/problem/281/A
// Level -> Easy;
// Approach -> String;
// Code ->
package Codeforce.String;
import java.util.Scanner;

public class AWordCapitalization281A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(s.substring(0, 1).toUpperCase() + s.substring(1));
    }
}

// Time Complexity -> O(n);
// Space Complexity -> O(1);