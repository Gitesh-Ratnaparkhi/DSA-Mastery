// 25. Reverse Nodes in k-Group

// Link -> https://leetcode.com/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=leetcode-75

// First Approach: Brute Force

// 1. We will use a dummy node to store the head of the reversed group.
// 2. We will use a variable to store the head of the previous group.
// 3. We will use a variable to store the head of the current group.
// 4. We will use a variable to store the tail of the current group.
// 5. We will use a variable to store the tail of the previous group.
// 6. We will use a variable to store the next node of the current group.
// 7. We will use a variable to store the next node of the previous group.
// 8. We will use a variable to store the next node of the next node of the current group.
// 9. We will use a variable to store the next node of the next node of the previous group.
// 10. We will use a variable to store the next node of the next node of the next node of the current group.
// 11. We will use a variable to store the next node of the next node of the next node of the previous group.
// 12. We will use a variable to store the next node of the next node of the next node of the next node of the current group.
// 13. We will use a variable to store the next node of the next node of the next node of the next node of the previous group.
// 14. We will use a variable to store the next node of the next node of the next node of the next node of the next node of the current group.
// 15. We will use a variable to store the next node of the next node of the next node of the next node of the next node of the previous group.
// 16. We will use a variable to store the next node of the next node of the next node of the next node of the next node of the next node of the current group.
// 17. We will use a variable to store the next node of the next node of the next node of the next node of the next node of the next node of the previous group.

// Code ->
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = null;
        ListNode prevGroup = null;

        while (head != null) {
            ListNode temp = head;
            int cnt = 0;

            while (temp != null && cnt < k) {
                temp = temp.next;
                cnt++;
            }

            if (cnt < k) {
                if (prevGroup != null) {
                    prevGroup.next = head;
                }
                break;
            }

            ListNode groupStart = head;
            ListNode prev = null;
            ListNode curr = head;

            for (int count = 0; count < k; count++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if (ans == null) {
                ans = prev;
            }

            if (prevGroup != null) {
                prevGroup.next = prev;
            }

            prevGroup = groupStart;
            head = curr;
        }

        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)

// Another Approach: Using Recursion
// 1. The reverseKGroup function takes two parameters: head, which is the head
// of the linked list, and k, which is the number of nodes to reverse.
// 2. The function first checks if the head is null, and if it is, it returns
// null.
// 3. The function then creates a tail variable that points to the kth node in
// the linked list. If the tail is null, it means the linked list has less than
// k nodes, so it returns the head.
// 4. The function then creates a newHead variable that points to the reversed
// head of the k-group.
// 5. The function then sets the next pointer of the head to the reversed tail
// of the k-group.
// 6. The function then returns the newHead.
// 7. The reverse function takes two parameters: cur, which is the current node,
// and end, which is the end node of the k-group.
// 8. The function first creates a prev variable that points to null.
// 9. The function then enters a loop that runs until the current node is equal
// to the end node.
// 10. The function then creates a next variable that points to the next node of
// the current node.
// 11. The function then sets the next pointer of the current node to the
// previous node.
// 12. The function then sets the prev variable to the current node.
// 13. The function then sets the current node to the next variable.
// 14. The function then returns the previous node.

// Code ->
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null)
                return head;
            tail = tail.next;
        }

        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    private ListNode reverse(ListNode cur, ListNode end) {
        ListNode prev = null;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)