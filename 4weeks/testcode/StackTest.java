package com.example.demo.whiteship;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @DisplayName("Stack push 1개 - 성공")
    @Test
    void test0() {

        Stack stack = new Stack();
        stack.push(1);
        assertEquals(stack.pop(), 1);
    }

    @DisplayName("Stack push 여러개 - 성공")
    @Test
    void test1() {

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(stack.pop(), 4);
        assertEquals(stack.pop(), 3);
        assertEquals(stack.pop(), 2);
        assertEquals(stack.pop(), 1);
    }

    @DisplayName("Stack push - 실패")
    @Test
    void test2() {

        Stack stack = new Stack();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.pop());

    }



}