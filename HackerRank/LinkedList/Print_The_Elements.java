// Print The Elements

// Link -> https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem

// Code ->

public class Solution {

    static void printLinkedList(SinglyLinkedListNode head) {

        if (head == null)
            return;
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(1) {
    

