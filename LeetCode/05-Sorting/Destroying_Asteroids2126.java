// 2126. Destroying Asteroids
// Link -> https://leetcode.com/problems/destroying-asteroids/description/
// Approach -> Sorting Brute Force [Medium]
// Code ->
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for(int i : asteroids){
            if(m >= i) m += i;
            else return false;
        }
        return true;
    }
}

// Time Complexity -> O(NlogN)
// Space Complexity -> O(1)