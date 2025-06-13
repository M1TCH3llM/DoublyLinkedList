package DoubleLL.DLLDeletion;

public class Main {
    public static void main(String[] args) {
   Delete list = new Delete();

   int val = 15;
//    int val = 0;
//    int val = 45;

    list.insertInOrder(15);
    list.insertInOrder(5);
    list.insertInOrder(25);
    list.insertInOrder(35);
    list.insertInOrder(0);
    list.insertInOrder(45);

    System.out.println("---------Initial List---------");
     list.printList(); // Print the linked list

     list.deleteByValue(val);
     System.out.println("After deleteByValue(" + val + "):");

     System.out.println("---------List After Deletion---------");
     list.printList();

     list.printListReverse();
         
System.out.println( "---------Insertion At Beginning---------");
    list.insertInOrder(1);

    list.printList();

    list.printListReverse();

    System.out.println( "---------Insertion At End---------");

    list.insertInOrder(50);

    list.printList();

    list.printListReverse();
    
    
    System.out.println( "---------Insertion In Middle---------");

    list.insertInOrder(28);

    list.printList();

    list.printListReverse();

    }
}
