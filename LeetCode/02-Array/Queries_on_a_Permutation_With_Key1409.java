// 1409. Queries on a Permutation With Key
// Link -> https://leetcode.com/problems/queries-on-a-permutation-with-key/description/
// Level -> Medium
// Approach -> Brute Force
// Code ->
class Solution {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<m; i++){
            arr.add(i+1);
        }
        int ans[] = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int val = queries[i];
            for(int j=0; j<arr.size(); j++){
                if(arr.get(j) == val){
                    ans[i] = j;
                    arr.remove(j);
                    arr.add(0, val);
                    break;
                }
            }
        }
        return ans;

    }
}

// Time Complexity -> O(n^2)
// Space Complexity -> O(n)