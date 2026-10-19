// 38. Count and Say
// Link -> https://leetcode.com/problems/count-and-say/description/
// Level -> Easy
// Approach -> Brute Force
// Code ->
class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        for(int i=1; i<n; i++){
            StringBuilder s = new StringBuilder();
            int len = sb.length();
            int cnt = 1;
            for (int j = 1; j < len; j++) {
                if(sb.charAt(j) == sb.charAt(j-1)) cnt++;
                else{
                    s.append(cnt).append(sb.charAt(j - 1));
                    cnt = 1;
                }
            }
            s.append(cnt).append(sb.charAt(len - 1));
            sb = s;
        }
        return sb.toString();
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)