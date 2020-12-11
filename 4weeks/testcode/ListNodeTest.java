package com.example.demo.whiteship;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.jupiter.api.Assertions.*;

public class ListNodeTest {

    @DisplayName(" ADD 성공")
    @Test
    void test1() {
        ListNode a = new ListNode(9);
        ListNode add = a.add(a, new ListNode(5), 1);
        ListNode add2 = add.add(a, new ListNode(4), 0);
        assertEquals(a.next.value , 4);
        assertEquals(a.next.next.value , 5);
    }

    @DisplayName(" ADD 실패")
    @Test
    void test2() {
        ListNode a = new ListNode(9);
        assertThrows(NullPointerException.class, () ->a.add(a, new ListNode(5), 3));
    }

    @DisplayName(" Remove 성공")
    @Test
    void test3() {
        ListNode a = new ListNode(9);
        ListNode add = a.add(a, new ListNode(5), 1);
        ListNode add2 = add.add(a, new ListNode(4), 1);

        a.remove(a, 2);

        assertEquals(a.next.value , 4);
    }

    @DisplayName(" Remove 실패")
    @Test
    void test4() {
        ListNode a = new ListNode(9);
        ListNode add = a.add(a, new ListNode(5), 1);
        ListNode add2 = add.add(a, new ListNode(4), 1);

        assertThrows(NullPointerException.class, ()->a.remove(a, 3));

    }

    @DisplayName(" Contains 성공")
    @Test
    void test5() {
        ListNode a = new ListNode(9);
        ListNode add = a.add(a, new ListNode(5), 1);
        ListNode add2 = add.add(a, new ListNode(4), 1);

        assertTrue(a.contains(a,new ListNode(5)));

    }

    @DisplayName(" Contains 실패")
    @Test
    void test6() {
        ListNode a = new ListNode(9);
        ListNode add = a.add(a, new ListNode(5), 1);
        ListNode add2 = add.add(a, new ListNode(4), 1);

        assertFalse(a.contains(a,new ListNode(6)));
        //assertThrows(NullPointerException.class, ()->a.remove(a, 3));
    }
}
