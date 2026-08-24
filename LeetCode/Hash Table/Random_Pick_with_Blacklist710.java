// 710. Random Pick with Blacklist

// Link - https://leetcode.com/problems/random-pick-with-blacklist/description/

// This question was asked in Google, Facebook, Amazon, Microsoft, Bloomberg, and many more.

// Approach : Hash Map , Brute Force
// 1. Create a HashSet to store the numbers in the blacklist.
// 2. Create a List to store the numbers that are not in the blacklist.
// 3. Traverse the input array and for each number, if it is not in the blacklist, add it to the List.
// 4. In the pick() method, generate a random index between 0 and the size of the List.
// 5. Return the number at the randomly generated index from the List.

// Code ->
class Solution {
    Set<Integer> st;
    List<Integer> nt;
    public Solution(int n, int[] blacklist) {
        st = new HashSet<>();
        for(int i : blacklist) st.add(i);

        nt = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(!st.contains(i)) nt.add(i);
        }
    }
    
    public int pick() {
        int n = nt.size(); 
        int r_index = (int)(Math.random() * n); 
        return nt.get(r_index);
    }
}

// This Code give TLE
// Time Complexity : O(n) for constructor and O(1) for pick() method
// Space Complexity : O(n) for storing the numbers not in the blacklist


// Approach :
// 1. Create a HashMap to store the numbers in the blacklist and their corresponding replacement numbers.
// 2. Traverse the input array and for each number, if it is not in the blacklist, add it to the HashMap.
// 3. In the pick() method, generate a random number between 0 and the size of the HashMap.
// 4. If the random number is in the HashMap, return its replacement number, otherwise return the original number.


// Code ->
class Solution {

    Map<Integer, Integer> mp;
    int size;

    public Solution(int n, int[] blacklist) {

        mp = new HashMap<>();
        size = n - blacklist.length;

        Set<Integer> black = new HashSet<>();

        for (int x : blacklist) {
            black.add(x);
        }

        int last = n - 1;

        for (int x : blacklist) {

            if (x < size) {

                while (black.contains(last)) {
                    last--;
                }

                mp.put(x, last);
                last--;
            }
        }
    }

    public int pick() {

        int x = (int)(Math.random() * size);

        if (mp.containsKey(x)) {
            return mp.get(x);
        }

        return x;
    }
}


// Time Complexity : O(B) for constructor and O(1) for pick() method where B is the length of blacklist
// Space Complexity : O(B)