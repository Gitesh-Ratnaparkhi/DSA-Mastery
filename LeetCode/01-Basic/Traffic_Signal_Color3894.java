// 3894. Traffic Signal Color

// Link -> https://leetcode.com/problems/traffic-signal-color/description/

// Approach -> Simple
// 1. Check the value of timer and return the corresponding traffic signal color based on the given conditions.
// 2. If timer is 0, return "Green".
// 3. If timer is 30, return "Orange".
// 4. If timer is greater than 30 and less than or equal to 90, return "Red".
// 5. If timer is outside the valid range, return "Invalid".

// Code ->
class Solution {
    public String trafficSignal(int timer) {
        if(timer == 0) return "Green";
        else if(timer == 30) return "Orange";
        else if(timer > 30 && timer <= 90) return "Red";
        return "Invalid";
    }
}

// Time Complexity: O(1)
// Space Complexity: O(1)