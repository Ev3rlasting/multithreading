package datastructure;

import lombok.Getter;

@Getter
public class LinkedListImpl implements LinkedList {
    private LinkedListNode head;
    private LinkedListNode tail;

    //    private int size = 0;

    public LinkedListImpl() {
        head = tail = null;
    }

    public void remove(int idx) {
        if (idx < 0) {
            return;
        }
        if (head.next == null) {
            if (idx != 0) {
                throw new IllegalArgumentException("Idx wrong!");
            }
            head = null;
            tail = null;
        }
        if (idx == 0) {
            LinkedListNode del = head;
            head = head.next;
            del = null;
            return;
        }
        int i = 0;
        LinkedListNode temp = head;
        while (temp.next != null) {
            if (i++ == idx - 1) {
                LinkedListNode toDelete = temp.next;
                temp.next = temp.next.next;
                toDelete = null;
                return;
            }
            temp = temp.next;
        }
        throw new IllegalArgumentException("Idx wrong!");
    }

    public void add(Object value) {
        if (head == null) {
            head = new LinkedListNode(value);
            tail = head;
            return;
        }
        tail.next = new LinkedListNode(value);
        tail = tail.next;
    }

    public Object get(int idx) {
        if (idx < 0) {
            return null;
        }
        LinkedListNode temp = head;
        int i = 0;
        while (temp != null) {
            if (i++ == idx) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }
}
