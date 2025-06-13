package DoubleLL.DLLInsertion;

public class DoublyLinkedList {

    private Node head;
    private Node tail;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        // If the list is empty, both head and tail will point to the new node
        if (head == null) {
            // If the list is empty, set both head and tail to the new node
            head = newNode;
            tail = newNode; // If the list is empty, set both head and tail to the new node
        } else {
            // If the list is not empty, insert the new node at the beginning
            newNode.next = head; // Point the new node's next to the current head
            head.prev = newNode; // Set the previous of current head to the new node
            head = newNode; // Update the head to the new node 
        }
    }

   

    public void insertInOrder(int data) {
        Node newNode = new Node(data);
        
        // If the list is empty or the new data is less than or equal to the head's data,
        if (head == null || data <= head.data) {
            //default case: insert at the beginning
            insertAtBeginning(data);
            return;
        }

        // If the new data is greater than or equal to the tail's data,
        if (data >= tail.data) {
            //default case: insert at the end
            Node newTail = new Node(data);
            tail.next = newTail; // Link the current tail to the new node
            newTail.prev = tail; // Set the previous of the new node to the current tail
            tail = newTail; // Update the tail to the new node
            return;
        }
        // If the new data is in between the head and tail, find the correct position
        Node current = head;
        // Traverse the list to find the correct position for the new node
        // Move to the next node until we find a node with data greater than or equal to the new data
        while (current != null && current.data < data) {
            // Move to the next node
            current = current.next;
        }
       // At this point, current is the first node with data greater than or equal to the new data
        // Insert the new node before the current node
        Node previous = current.prev;

        previous.next = current.prev; // Get the previous node
        newNode.prev = previous; // Set the previous of the new node
        newNode.next = current; // Link the new node to the current node
        current.prev = newNode; // Set the previous of the current node to the new nod
    }


 public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println("null");
    }

 public void printListReverse() {
        Node curr = tail;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.prev;
        }
        System.out.println("null");
    }

}