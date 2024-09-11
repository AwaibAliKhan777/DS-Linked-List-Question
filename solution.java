// 19. Remove Nth Node From End of List

import java.util.List;

// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {

    // Function to remove the nth node from the end of the linked list
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null; // If the list is empty, return null
        }

        // Calculate the size of the linked list
        int size = 0;
        ListNode curr = head;
        while (curr != null) { // Traverse until the end of the list
            curr = curr.next;
            size++;
        }

        // If n equals the size of the list, remove the head
        if (n == size) {
            return head.next;
        }

        // Find the node just before the one to be removed
        int indexToSearch = size - n; // The index of the node to be removed
        ListNode prev = head; // Start from the head of the list
        int i = 1; // Track the position

        while (i < indexToSearch) { // Move to the node just before the target node
            prev = prev.next;
            i++;
        }

        // Remove the nth node by skipping it
        prev.next = prev.next.next;

        return head; // Return the modified list
    }
}
