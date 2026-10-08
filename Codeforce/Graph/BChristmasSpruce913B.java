// BChristmasSpruce
// Link -> https://codeforces.com/problemset/problem/913/B
// Level -> Easy;
// Approach -> Graph;
// Code ->
package Codeforce.Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class BChristmasSpruce913B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();

        ArrayList<Integer> tree[] = new ArrayList[node + 1];
        for (int i = 1; i <= node; i++) tree[i] = new ArrayList<>();

        for(int i=1; i<node; i++){
            int par = sc.nextInt();
            int child = i + 1; 
            tree[par].add(child);
        }
        
        for (int i = 1; i <= node; i++) {
            if(tree[i].size() > 0){
                int lc = 0;
                for(int child : tree[i]){
                    if(tree[child].size() == 0) lc++;
                }
                if(lc < 3){
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}

// Time Complexity -> O(n);
// Space Complexity -> O(n);
