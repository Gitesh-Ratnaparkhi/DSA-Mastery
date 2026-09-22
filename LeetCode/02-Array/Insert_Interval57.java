// 57. Insert Interval

// Link -> https://leetcode.com/problems/insert-interval/description/

// Level -> Medium
// Approach -> Greedy
// Code ->
class Solution {
    public int[][] insert(int[][] inte, int[] newi) {
        int i = 0;
        List< int[]> ans = new ArrayList<>();
        int n = inte.length;
        while(i < n){
            if(inte[i][1] < newi[0]) ans.add(inte[i]);
            else if(inte[i][0] > newi[1]) break;
            else{
                newi[0] = Math.min(newi[0], inte[i][0]);
                newi[1] = Math.max(newi[1], inte[i][1]);
            }
            i++;
        }
        ans.add(newi);
        while(i < n){
            ans.add(inte[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)