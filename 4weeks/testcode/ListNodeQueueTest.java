package com.example.demo.whiteship;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeQueueTest {

    @DisplayName("ListNodeQueue push & peek 단일 - 성공")
    @Test
    void test0() {
        ListNodeQueue queue = new ListNodeQueue();
        queue.push(1);

        assertEquals(queue.peek(), 1);

    }

    @DisplayName("ListNodeQueue push & peek 복수 - 성공")
    @Test
    void test1() {
        ListNodeQueue queue = new ListNodeQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        assertEquals(queue.peek(), 1);
        assertEquals(queue.peek(), 2);
        assertEquals(queue.peek(), 3);
        assertEquals(queue.peek(), 4);

    }

    @DisplayName("ListNodeQueue peek - 실패")
    @Test
    void test2() {
        ListNodeQueue queue = new ListNodeQueue();
        assertThrows(NullPointerException.class, () -> queue.peek());
    }

}