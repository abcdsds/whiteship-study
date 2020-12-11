package com.example.demo.whiteship;

public class ListNodeQueue {

    ListNode head;
    int size;

    public ListNodeQueue () {
        head = new ListNode();
        size = 0;
    }
    public void push(int data) {
        head.add(head, new ListNode(data), ++size);
    }

    public int peek() {

        ListNode temp = head.next;
//        for (int i=0; i<size - 1; i++) {
//            temp = temp.next;
//        }

        int value = temp.value;
        head.remove(head, 1);
        --size;
        return value;
    }
}
