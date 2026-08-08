// 1701. Average Waiting Time

// Link : https://leetcode.com/problems/average-waiting-time/description/

// Approach :
// 1. We will keep track of the current time and the total waiting time.
// 2. For each customer, we will update the current time to the maximum of the current time and the arrival time of the customer.
// 3. We will add the waiting time of the customer to the total waiting time.
// 4. Finally, we will return the average waiting time.

// Code ->
class Solution {
    public double averageWaitingTime(int[][] customers) {
        long curr = 0;
        long wt = 0;

        for (int i = 0; i < customers.length; i++) {
            curr = Math.max(curr, customers[i][0]);
            curr += customers[i][1];
            wt += curr - customers[i][0];
        }

        return (double) wt / customers.length;
    }
}

// Time Complexity : O(n) where n is the number of customers
// Space Complexity : O(1)
