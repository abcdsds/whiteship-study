package com.example.demo.whiteship;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @DisplayName("Queue Push Test 1개 - 성공")
    @Test
    void test0() {
        Queue queue = new Queue();
        queue.push(1);

        Assertions.assertEquals(queue.peek(), 1);
    }

    @DisplayName("Queue Push Test - 성공")
    @Test
    void test1() {
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        Assertions.assertEquals(queue.peek(), 1);
        Assertions.assertEquals(queue.peek(), 2);
        Assertions.assertEquals(queue.peek(), 3);
    }

    @DisplayName("Queue Push Test - 실패")
    @Test
    void test2() {
        Queue queue = new Queue();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.peek());
    }

}