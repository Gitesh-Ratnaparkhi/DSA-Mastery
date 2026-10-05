// APetyaAndStrings
// Link -> https://codeforces.com/problemset/problem/112/A
// Level -> Easy;
// Approach -> Linear Search;
// Code ->

package Codeforce.String;

import java.util.Scanner;

public class APetyaAndStrings112A {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) < s2.charAt(i)){
                System.out.println(-1);
                return;
            }else if(s1.charAt(i) > s2.charAt(i)){
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
        
    }
}

// Time Complexity -> O(n) where n is the length of the string
// Space Complexity -> O(1)
