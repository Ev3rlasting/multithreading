package algo;

import datastructure.LinkedListImpl;
import datastructure.LinkedListNode;

public class MergeSortedLinkedList {

    public static LinkedListNode merge(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        LinkedListNode result;
        LinkedListNode other;
        if (Integer.parseInt(l1.value.toString()) <= Integer.parseInt(l2.value.toString())) {
            result = l1;
            other = l2;
        } else {
            result = l2;
            other = l1;
        }
        LinkedListNode soFar = result;
        LinkedListNode temp = soFar.next;
        while (temp != null) {
            if (Integer.parseInt(temp.value.toString()) < Integer.parseInt(other.value.toString())) {
                temp = temp.next;
            } else {
                soFar.next = other;
                soFar = soFar.next;
                other = temp;
                temp = soFar.next;
            }
        }
        soFar.next = other;
        return result;
    }

    public static void main(String[] args) {
        LinkedListImpl l1 = new LinkedListImpl();
        LinkedListImpl l2 = new LinkedListImpl();

        l1.add(1);
        l1.add(3);
        l1.add(5);
        l1.add(7);
        l1.add(9);
        
        l2.add(2);
        l2.add(4);
        l2.add(6);
        l2.add(10);

        merge(l1.getHead(), l2.getHead());

        return;
    }

}
