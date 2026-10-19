// ABeautifulYear
// Link -> https://codeforces.com/problemset/problem/4/A
// Level -> Easy;
// Approach -> Linear Search;
// Code ->


package Codeforce.Basic;

import java.util.Scanner;

public class ABeautifulYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        
        while (true) {
            y++;
            if (hasDistinctDigits(y)) {
                System.out.println(y);
                break;
            }
        }
        scanner.close();
    }
    
    private static boolean hasDistinctDigits(int year) {
        boolean[] seen = new boolean[10];
        
        while (year > 0) {
            int digit = year % 10;
            if (seen[digit]) {
                return false;
            }
            seen[digit] = true;
            year /= 10;
        }
        
        return true;
    }
}

// Time Complexity -> O(1);
// Space Complexity -> O(1);