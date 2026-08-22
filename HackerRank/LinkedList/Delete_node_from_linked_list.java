// Delete A Node From A Linked List

// Link -> https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem

// Code ->
class Result {

    /*
     * Complete the 'deleteNode' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     * 1. INTEGER_SINGLY_LINKED_LIST llist
     * 2. INTEGER position
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     * int data;
     * SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // Write your code here

        if (llist == null)
            return null;
        if (position == 0)
            return llist.next;
        SinglyLinkedListNode prev = llist;
        for (int i = 0; i < position - 1 && prev != null; i++)
            prev = prev.next;
        if (prev != null && prev.next != null)
            prev.next = prev.next.next;

        return llist;
    }

}

// Time Complexity -> O(n)
// Space Complexity -> O(1)