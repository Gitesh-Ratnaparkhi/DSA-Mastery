// AWrongSubtraction
// Link -> https://codeforces.com/problemset/problem/977/A
// Level -> Easy;
// Approach -> Linear Search;
// Code ->
package Codeforce.Basic;

import java.util.Scanner;

public class AWrongSubtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int op = sc.nextInt();  

        while(op > 0 && num > 0) {
            if(num % 10 == 0) {
                num /= 10;
            } else {
                num--;
            }
            op--;
        }
        System.out.println(num);
    }
}


// Time Complexity -> O(n);
// Space Complexity -> O(1);