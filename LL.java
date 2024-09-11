public class LL {
    Node head; // Head node to track the start of the linked list

    // Node class to represent each element in the linked list
    class Node {
        String data; // Data field to store the value of the node
        Node next;   // Pointer to the next node in the list

        // Constructor to initialize the data field and set 'next' to null
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to add a node at the beginning of the list
    public void addFirst(String data) {
        // Create a new node with the given data
        Node newNode = new Node(data);
        // If the list is empty, set the new node as the head
        if (head == null) {
            head = newNode;
            return;
        }
        // Link the new node to the current head, then update the head
        newNode.next = head;
        head = newNode;
    }

    // Method to add a node at the end of the list
    public void addLast(String data) {
        // Create a new node with the given data
        Node newNode = new Node(data);
        // If the list is empty, set the new node as the head
        if (head == null) {
            head = newNode;
            return;
        }
        // Traverse to the last node in the list
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        // Link the last node to the new node
        currNode.next = newNode;
    }

    // Method to print the entire list
    public void printList() {
        // If the list is empty, print a message
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        // Traverse the list and print each node's data
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println("Null"); // Indicate the end of the list
    }

    // Method to remove the first node from the list
    public void removeFirst() {
        // If the list is empty, print a message
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        // Move the head to the next node, effectively removing the first node
        head = head.next;
    }

    // Method to remove the last node from the list
    public void removeLast() {
        // If the list is empty, print a message
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        // If there's only one node, set the head to null
        if (head.next == null) {
            head = null;
            return;
        }
        // Traverse to the second last node
        Node currNode = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            currNode = currNode.next;
            lastNode = lastNode.next;
        }
        // Set the second last node's next to null, effectively removing the last node
        currNode.next = null;
    }

    // Method to reverse the list iteratively
    public void reverseIterate() {
        // If the list is empty or has only one node, no need to reverse
        if (head == null || head.next == null) {
            return;
        }
        // Initialize previous and current pointers
        Node prevNode = head;
        Node currNode = head.next;

        // Traverse the list and reverse the links
        while (currNode != null) {
            Node nextNode = currNode.next; // Store the next node
            currNode.next = prevNode;      // Reverse the current node's next pointer
            prevNode = currNode;           // Move prevNode to the current node
            currNode = nextNode;           // Move currNode to the next node
        }

        // Set the old head's next to null and update the head
        head.next = null;
        head = prevNode;
    }

    // Method to reverse the list recursively
    public Node reverseRecursive(Node head) {
        // Base case: if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        Node newHead = reverseRecursive(head.next);

        // Reverse the current node's next pointer
        head.next.next = head;
        head.next = null; // Set the current node's next to null

        return newHead; // Return the new head after reversal
    }

    // Main method to test the linked list operations
    public static void main(String[] args) {
        LL list = new LL();

        // Add nodes at the beginning of the list
        list.addFirst("4");
        list.addFirst("3");
        list.addFirst("2");
        list.addFirst("1");
        list.printList(); // Output: 1->2->3->4->Null

        // Add a node at the end of the list
        list.addLast("5");
        list.printList(); // Output: 1->2->3->4->5->Null

        // Remove the first node
        list.removeFirst();
        list.printList(); // Output: 2->3->4->5->Null

        // Remove the last node
        list.removeLast();
        list.printList(); // Output: 2->3->4->Null

        // Reverse the list iteratively
        list.reverseIterate();
        list.printList(); // Output: 4->3->2->Null

        // Reverse the list recursively
        list.head = list.reverseRecursive(list.head);
        list.printList(); // Output: 2->3->4->Null
    }
}
