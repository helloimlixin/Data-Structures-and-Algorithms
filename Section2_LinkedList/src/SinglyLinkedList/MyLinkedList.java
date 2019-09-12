package SinglyLinkedList;

class MyLinkedList {
    public class SinglyLinkedListNode {
        int value;
        SinglyLinkedListNode next;
        SinglyLinkedListNode() {}
        SinglyLinkedListNode(int x) {
            value = x;
        }
    }

    /** Initialize your data structure here. */
    SinglyLinkedListNode head = null;
    MyLinkedList() {}

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    int get(int index) {
        if (index < 0) return -1;
        SinglyLinkedListNode node = getNode(index);
        return node == null ? -1 : node.value;
    }

    /** Get the index-th node in the linked list. If the index is invalid, return null. */
    SinglyLinkedListNode getNode(int index) {
        SinglyLinkedListNode node = head;
        for (int i = 0; i < index && node != null; ++i) {
            node = node.next;
        }
        return node;
    }

    /** Get the tail node in the linked list. If the index is invalid, return null. */
    SinglyLinkedListNode getTail() {
        SinglyLinkedListNode node = head;
        while (node != null && node.next != null) {
            node = node.next;
        }
        return node;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    void addAtHead(int val) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(val);
        node.next = head;
        head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        SinglyLinkedListNode previous = getTail();
        SinglyLinkedListNode node = new SinglyLinkedListNode(val);
        previous.next = node;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        SinglyLinkedListNode previous = getNode(index - 1);
        if (previous == null) return;
        SinglyLinkedListNode node = new SinglyLinkedListNode(val);
        SinglyLinkedListNode next = previous.next;
        node.next = next;
        previous.next = node;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    void deleteAtIndex(int index) {
        SinglyLinkedListNode node = getNode(index);
        if (node == null) return;
        if (index == 0) {
            head = head.next;
        }
        SinglyLinkedListNode previous = getNode(index - 1);
        SinglyLinkedListNode next = node.next;
        if (previous != null) {
            previous.next = next;
        } else {
            head = next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */