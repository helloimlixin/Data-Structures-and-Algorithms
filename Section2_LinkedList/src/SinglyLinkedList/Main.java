package SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
//        obj.addAtHead(1);
//        obj.addAtTail(3);
        obj.addAtIndex(-1,0);
        System.out.println(obj.get(0));
        obj.deleteAtIndex(-1);
//        System.out.println(obj.get(-3));
    }
}
