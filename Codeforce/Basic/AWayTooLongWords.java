package Codeforce.Basic;

import java.util.Scanner;

public class AWayTooLongWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        for(int j=0; j<i; j++){
            String word = sc.next();
            int n = word.length();
            if(n <= 10) System.out.println(word);
            else System.out.println(word.charAt(0) + Integer.toString(n - 2) + word.charAt(n - 1));
        }
        
    }
}
