import java.util.Scanner;

public class ATeam{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int arr[][] = new int[row][3];
        for(int i=0; i<row; i++){
            for(int j=0; j<3; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for(int i=0; i<row; i++){
            int cnt = 0;
            for(int j=0; j<3; j++){
                if(arr[i][j] == 1){
                    cnt++;
                }
            }
            ans += cnt >= 2 ? 1 : 0;
        }
        System.out.println(ans);
    }
}