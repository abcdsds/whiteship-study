package com.example.demo.whiteship;

import java.util.LinkedList;

public class ListNode {

    public ListNode next;
    public int value;

    public ListNode () {
    }

    public ListNode (int value) {
        this.value = value;
    }

    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {

        if (position == 0) {
            nodeToAdd.next = head;
        }

        ListNode temp = head;

        for (int i=0; i<position-1; i++) {
            temp = temp.next;
        }

        nodeToAdd.next = temp.next;
        temp.next = nodeToAdd;
        return nodeToAdd;
    }

    public ListNode remove(ListNode head, int positionToRemove){

        ListNode temp = head;

        for (int i=0; i<positionToRemove-1; i++) {
            temp = temp.next;
        }
        ListNode tempNext = temp.next;
        temp.next = tempNext.next;
        tempNext = null;
        return temp;
    }

    public boolean contains(ListNode head, ListNode nodeTocheck) {

        ListNode temp = head;
        while (temp != null) {
             if (temp.value == nodeTocheck.value) {
                 return true;
             }
             temp = temp.next;
        }
        return false;
    }


}
