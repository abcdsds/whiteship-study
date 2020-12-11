package com.example.demo.whiteship;

public class ListNodeStack {

    ListNode head;
    int size;

    public ListNodeStack() {
        head = new ListNode();
        size = 0;
    }

    public void push(int data) {
        head.add(head, new ListNode(data), ++size);
    }

    public int pop() {

        ListNode temp = head;
        for (int i=0; i<size; i++) {
            temp = temp.next;
        }

        int value = temp.value;
        head.remove(head , size);
        --size;
        return value;
    }
}
