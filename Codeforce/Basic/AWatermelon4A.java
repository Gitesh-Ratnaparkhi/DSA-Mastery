package Codeforce.Basic;
import java.util.Scanner;
public class AWatermelon4A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wt = sc.nextInt();
        if(wt > 2 && wt % 2 == 0) System.out.println("YES");
        else System.out.println("NO");
    }
}
