package com.example.demo.whiteship;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeStackTest {

    @DisplayName("ListNodeStack Push - 성공")
    @Test
    void test01() {

        ListNodeStack lnd = new ListNodeStack();
        lnd.push(1);
        Assertions.assertEquals(lnd.pop(), 1);
    }


    @DisplayName("ListNodeStack Push 여러개 - 성공")
    @Test
    void test02() {

        ListNodeStack lnd = new ListNodeStack();
        lnd.push(1);
        lnd.push(2);
        lnd.push(3);


        Assertions.assertEquals(lnd.pop(), 3);

    }

    @DisplayName("ListNodeStack Pop - 성공")
    @Test
    void test03() {

        ListNodeStack lnd = new ListNodeStack();
        lnd.push(1);
        lnd.push(2);
        lnd.push(3);


        Assertions.assertEquals(lnd.pop(), 3);

    }

    @DisplayName("ListNodeStack Pop 여러개 - 성공")
    @Test
    void test04() {

        ListNodeStack lnd = new ListNodeStack();
        lnd.push(1);
        lnd.push(2);
        lnd.push(3);


        Assertions.assertEquals(lnd.pop(), 3);
        Assertions.assertEquals(lnd.pop(), 2);
        Assertions.assertEquals(lnd.pop(), 1);

    }

    @DisplayName("ListNodeStack Pop 테스트 - 실패")
    @Test
    void test05() {

        ListNodeStack lnd = new ListNodeStack();
        Assertions.assertThrows(NullPointerException.class, () -> lnd.pop());

    }

}