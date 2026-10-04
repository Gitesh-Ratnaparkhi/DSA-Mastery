// ABit
// Link -> https://codeforces.com/problemset/problem/282/A
// Level -> Easy;
// Approach -> Linear Search;
// Code ->

package Codeforce.Basic;

import java.util.Scanner;

public class ABit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for(int i=0; i<n; i++){
            String s = sc.next();
            if(s.charAt(0) == 'X'){
                if(s.substring(1, 3).equals("++")) ans++;
                else ans--;
            }else{
                if(s.substring(0, 2).equals("++")) ans++;
                else ans--;
            }
        }
        System.out.println(ans);
    }
}

// Time Complexity -> O(n);
// Space Complexity -> O(1);