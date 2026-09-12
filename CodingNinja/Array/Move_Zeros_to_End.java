// Move Zero's to End
// Link -> https://www.naukri.com/code360/problems/ninja-and-the-zero-s_6581958?leftPanelTabValue=PROBLEM
// Level -> Easy
// Topic -> Array
// Code ->
public class Move_Zeros_to_End {
    public static int[] moveZeros(int n, int []a) {
    // Write your code here.
    int ans[] = new int[n];
    int idx = 0;
    for(int i : a){
        if(i != 0){
            ans[idx]=i;
            idx++;
        }
    }
    while(idx < n){
        ans[idx] = 0;
        idx++;
    }
    return ans;
}
}

// Time Complexity: O(n)
// Space Complexity: O(n)