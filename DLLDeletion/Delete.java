package DoubleLL.DLLDeletion;

public class Delete {

    private Node head;
    private Node tail;

    public void insertInOrder(int data) {
        // 1) empty or new head
        
        if (head == null || data < head.data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev    = newNode;
                head         = newNode;
            }
            return;
        }

        // 2) new tail
        if (data > tail.data) {
            Node newNode = new Node(data);
            tail.next    = newNode;
            newNode.prev = tail;
            tail         = newNode;
            return;
        }

        // 3) somewhere in the middle
        Node current = head.next;
        while (current != null && current.data < data) {
            current = current.next;
        }
        // if equal, don’t insert a duplicate
        if (current != null && current.data == data) return; 

        // splice before 'current'
        Node newNode = new Node(data);
        Node previous = current.prev;

        previous.next = newNode;
        newNode.prev  = previous;

        newNode.next  = current;
        current.prev  = newNode;
    }

    public void deleteAtPosition(int pos) {
        // Special case: remove the head
        // if pos is 0, we need to remove the head node
         if (pos == 0) {
            // if the list is empty, do nothing
            Node toDelete = head;
            head = head.next; // move head to the next node
            // if the list becomes empty, update tail to null
            if (head != null) { // if head is not null, set its prev to null
                head.prev = null; // update head's prev to null
            } else {
                tail = null; // if head is null, tail should also be null
            }
            //clears the references to help garbage collection
            toDelete.next = null; // help GC 
            toDelete.prev = null; // help GC
            return;
        }

        // walk to the node before the one we want to delete
        Node current = head;
        // if pos is 1, prev is already at the right place
        for (int i = 0; i < pos && current != null; i++) {
            // move to the next nod
            current = current.next;
        }
        // if current is null, we are trying to delete a node that doesn't exist
      if (current == null) return;

    // if we're deleting tail
          if (current == tail) {
        tail = tail.prev;
        tail.next = null;
          } else {
        // splice out current for middle nodes
        current.prev.next = current.next;
        current.next.prev = current.prev;
        }
        // help GC
        current.next = null; // help GC
        current.prev = null; // help GC
}
    public int findPosition(int value) {
        Node curr = head;
        int idx = 0;
        while (curr != null) {
            if (curr.data == value) return idx;
            curr = curr.next;
            idx++;
        }
        return -1;
    }

public void deleteByValue(int value) {
    int p = findPosition(value);
    if (p < 0 ) {
        System.out.println("Value " + value + " not found in the list.");
    
    } else {
        deleteAtPosition(p);
        System.out.println("Deleted value: " + value);
    }
}

    public void printList() {
    Node curr = head;
    while (curr != null) {
        System.out.print(curr.data + " ");
        curr = curr.next;
    }
    System.out.println();
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
