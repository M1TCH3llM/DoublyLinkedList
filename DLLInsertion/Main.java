
package DoubleLL.DLLInsertion;

public class Main {
public static void main(String[] args) {
    DoublyLinkedList list = new DoublyLinkedList();

    list.insertAtBeginning(10);
    list.insertAtBeginning(20);
    list.insertAtBeginning(30);
    list.insertAtBeginning(40);
    list.insertAtBeginning(50);
    list.insertAtBeginning(60);

    // list.insertInOrder(15);
    // list.insertInOrder(5);
    // list.insertInOrder(25);
    // list.insertInOrder(35);
    // list.insertInOrder(0);
    // list.insertInOrder(45);


    list.printList(); // Print the linked list
    list.printListReverse();
}
}