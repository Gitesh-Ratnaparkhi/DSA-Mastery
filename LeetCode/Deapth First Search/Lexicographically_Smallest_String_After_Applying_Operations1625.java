// 1625. Lexicographically Smallest String After Applying Operations


// Link: https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/description/


// Approach: First Approach
// To find the lexicographically smallest string after applying the operations, we can use a depth-first search (DFS) approach. We will keep track of the visited strings to avoid cycles and repeatedly apply the two operations: adding 'a' to all odd indices and rotating the string by 'b' positions. We will compare the resulting strings and keep track of the smallest one found during the search.



// Code -> 
class Solution {

    Set<String> visited = new HashSet<>();

    private String solver(char[] s, int a, int b) {

        String curr = String.valueOf(s);
        if (visited.contains(curr)) return curr;
        

        visited.add(curr);
        String ans = curr;
        char[] add = s.clone();

        for (int i = 0; i < add.length; i++) {

            if (i % 2 != 0) {
                int num = (add[i] - '0' + a) % 10;
                add[i] = (char) (num + '0');
            }
        }

        String k = solver(add, a, b);

        if (k.compareTo(ans) < 0) ans = k;
        
        int n = s.length;
        char[] temp = new char[n];
        for (int i = 0; i < n; i++) temp[(i + b) % n] = s[i];
        String x = solver(temp, a, b);
        if (x.compareTo(ans) < 0) ans = x;

        return ans;
    }

    public String findLexSmallestString(String s, int a, int b) {
        char[] arr = s.toCharArray();
        return solver(arr, a, b);
    }
}


// Time Complexity: O(n²)
// Space Complexity: O(n²)