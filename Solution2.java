//234. Palindrome Linked List

// Definition for singly-linked list.
class ListNode {
    int val; // Value stored in the node
    ListNode next; // Pointer to the next node in the list

    // Constructor to initialize a ListNode with a value
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    // Optional constructor to initialize a ListNode with a value and a reference to the next node
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution2 {

    // Function to find the middle node of a linked list using the "hare and turtle" approach
    public ListNode findmiddle(ListNode head) {
        ListNode hare = head;   // fast pointer (moves 2 steps at a time)
        ListNode turtle = head; // slow pointer (moves 1 step at a time)

        // Continue moving the pointers until the fast pointer reaches the end of the list
        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;    // move hare 2 steps ahead
            turtle = turtle.next;     // move turtle 1 step ahead
        }
        // Turtle will now be pointing to the middle node
        return turtle;
    }

    // Function to reverse the linked list starting from the given node
    public ListNode reverse(ListNode head) {
        ListNode prev = null;  // Initially, the previous node is null
        ListNode curr = head;  // Start from the head of the list
        while (curr != null) {
            ListNode next = curr.next;  // Store the next node
            curr.next = prev;           // Reverse the link to point to the previous node
            prev = curr;                // Move the previous pointer one step ahead
            curr = next;                // Move the current pointer one step ahead
        }
        // After the loop, prev will point to the new head of the reversed list
        return prev;
    }

    // Function to check if a linked list is a palindrome
    public boolean isPalindrome(ListNode head) {
        // If the list is empty or has only one node, it is a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the list
        ListNode firstHalfStart = head;
        ListNode middle = findmiddle(head);

        // Reverse the second half of the list starting from the node after the middle
        ListNode secondHalfStart = reverse(middle.next);

        // Compare the first half and the reversed second half
        while (secondHalfStart != null) {
            if (firstHalfStart.val != secondHalfStart.val) {
                return false;  // If any values are different, it's not a palindrome
            }
            firstHalfStart = firstHalfStart.next;    // Move forward in the first half
            secondHalfStart = secondHalfStart.next;  // Move forward in the second half
        }

        // If we have compared all the nodes and found no mismatches, it's a palindrome
        return true;
    }
    public static void main(String[] args) {
        // Creating the linked list: 1 -> 2 -> 3 -> 2 -> 1
        ListNode node5 = new ListNode(1);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        // Initialize Solution2 and check if the linked list is a palindrome
        Solution2 solution = new Solution2();
        boolean result = solution.isPalindrome(node1);

        // Output the result 
        if (result) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}


