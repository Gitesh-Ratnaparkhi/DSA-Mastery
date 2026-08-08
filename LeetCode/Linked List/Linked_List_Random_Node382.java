// 382. Linked List Random Node

// Link -> https://leetcode.com/problems/linked-list-random-node/description/

// Approach -> Linked List
// 1. Create a list to store the values of the linked list nodes.
// 2. Traverse the linked list and add each node's value to the list.
// 3. Generate a random index between 0 and the size of the list.
// 4. Return the value at the randomly generated index.

// Code ->
class Solution {
    List<Integer> arr;
    public Solution(ListNode head) {
        arr  = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }
    }
    
    public int getRandom() {
        int n = arr.size();
        int r_index = (int)(Math.random() * n);
        return arr.get(r_index);
    }
}


// Time Complexity -> O(n) for constructor and O(1) for getRandom() method
// Space Complexity -> O(n)


// Approach -> Reservoir Sampling
// 1. Initialize a variable to keep track of the number of nodes seen so far (i).
// 2. Initialize a variable to store the randomly selected node's value (ans).
// 3. Initialize a variable to store the current node in the linked list (p).
// 4. While p is not null, generate a random number between 0 and i and check if it is less than or equal to 1. If it is, update ans to the current node's value and increment i.
// 5. Move to the next node (p = p.next).
// 6. Return the randomly selected node's value (ans).


// Code ->
class Solution {
    int N = 0;
    ListNode head = null;
    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        ListNode p = this.head;
        int i = 1, ans = 0;
        while (p != null) {
            if (Math.random() * i < 1) ans = p.val; 
            p = p.next;
            i ++;
        }
        return ans;
    }
}

// Time Complexity -> O(n) for constructor and O(1) for getRandom() method
// Space Complexity -> O(1)