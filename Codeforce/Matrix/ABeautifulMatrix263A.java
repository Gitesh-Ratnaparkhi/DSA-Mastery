// ABeautifulMatrix
// Link -> https://codeforces.com/problemset/problem/263/A
// Level -> Easy;
// Approach -> Linear Search;
// Code ->

package Codeforce.Matrix;

import java.util.Scanner;

public class ABeautifulMatrix263A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mat[][] = new int[5][5];

        int onex = 0;
        int oney = 0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                mat[i][j] = sc.nextInt();
                if(mat[i][j] == 1){
                    onex = i;
                    oney = j;
                }
            }
        }
    
        System.out.print(Math.abs(2 - onex) + Math.abs(2 - oney));
    }
}

// Time Complexity -> O(n^2) where n is the size of the matrix
// Space Complexity -> O(1)