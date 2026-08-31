// 1317. Convert Integer to the Sum of Two No-Zero Integers
// Link -> https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/?envType=daily-question&envId=2026-07-26
// Approach -> Math [EASY]
// Code ->
class Solution {
    private boolean check(int n){
        while(n > 0){
            if(n % 10 == 0)return false;
            n/=10;
        }
        return true;
    }
    public int[] getNoZeroIntegers(int n) {
        int ans[] = new int[2];
        for(int i = 1; i < n; i++){
            if(check(i) && check(n-i)){
                ans[0]=i;
                ans[1]=n-i;
                break;
            } 
        }
        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)