// 1845. Seat Reservation Manager
// Link -> https://leetcode.com/problems/seat-reservation-manager/description/
// Difficulty -> Medium
// Approach -> Priority Queue
// Code ->
class SeatManager {

    boolean arr[];
    PriorityQueue<Integer> mh;
    public SeatManager(int n) {
        mh = new PriorityQueue<>();
        arr = new boolean[n+1];
        for(int i =1; i<= n; i++){
            mh.offer(i);
            arr[i] = false;
        }
    }
    
    public int reserve() {
        int ans = mh.poll();
        arr[ans] = true;
        return ans;
    }
    
    public void unreserve(int seatNumber) {
        if(arr[seatNumber]){
            arr[seatNumber] = false;
            mh.offer(seatNumber);
        }
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */

// Time Complexity -> O(1)
// Space Complexity -> O(n)