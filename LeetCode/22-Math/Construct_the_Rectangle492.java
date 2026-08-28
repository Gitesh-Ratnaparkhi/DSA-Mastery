// 492. Construct the Rectangle
// Link -> https://leetcode.com/problems/construct-the-rectangle/description/?envType=daily-question&envId=2026-07-26
// Approach -> Math [EASY]
// Code ->
class Solution {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        
        while (area % w != 0) {
            w--;
        }
        
        int l = area / w;
        
        return new int[]{l, w};
    }
}

// Time Complexity -> O(1)
// Space Complexity -> O(1)