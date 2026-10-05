// 3170. Lexicographically Minimum String After Removing Stars

// Link -> https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/description/
// Difficulty -> Medium
// Approach -> Priority Queue 
// Code ->
class Solution {

    public class Pair {
        char ch;
        int idx;

        public Pair(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }

    public String clearStars(String s) {
        PriorityQueue<Pair> minh = new PriorityQueue<>((a, b) -> {
            if (a.ch != b.ch) return Character.compare(a.ch, b.ch); 
            return Integer.compare(b.idx, a.idx);     
        });    
        int arr[] = new int[s.length()];   
        for(int i=0; i<s.length(); i++){
            if(!minh.isEmpty() && s.charAt(i) == '*'){
                Pair min = minh.poll();
                arr[min.idx] = 1;
                arr[i] = 1;
            }else minh.offer(new Pair(s.charAt(i), i));
        }
        String ans = "";
        for(int i=0; i<s.length(); i++){
            if(arr[i] != 1) ans += s.charAt(i);
        }
        return ans;
    }
}

// Time Complexity: O(nlogn) where n is the length of the string s.
// Space Complexity: O(n)