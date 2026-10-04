import java.util.Scanner;
public class ANextRound{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noplayers = sc.nextInt();
        int k = sc.nextInt();
        int score[] = new int[noplayers];
        for(int i=0; i<noplayers; i++) score[i] = sc.nextInt();
        int ans = 0;
        for(int i=0; i<noplayers; i++){
            if(score[i] >= score[k-1] && score[i] > 0) ans++;
        }
        System.out.println(ans);
    }
}