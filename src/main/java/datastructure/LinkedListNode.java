package datastructure;

public class LinkedListNode {
    public Object value;
    public LinkedListNode next;

    public LinkedListNode() {

    }

    public LinkedListNode(Object value) {
        this.value = value;
        this.next = null;
    }

    public Object getValue() {
        return this.value;
    }

    public LinkedListNode getNext() {
        return this.next;
    }
}
