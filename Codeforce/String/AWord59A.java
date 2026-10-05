// AWord
// Link -> https://codeforces.com/problemset/problem/59/A
// Level -> Easy;
// Approach -> String;
// Code ->

package Codeforce.String;

import java.util.Scanner;

public class AWord59A {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int l = 0; int up = 0;
        for(int i=0; i<s.length(); i++){
            if(Character.isUpperCase(s.charAt(i)))up++;
            else l++;
        }
        if(up>l) System.out.println(s.toUpperCase());
        else System.out.println(s.toLowerCase());
    }
}

// Time Complexity -> O(n);
// Space Complexity -> O(1);