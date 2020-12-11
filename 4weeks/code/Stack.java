package com.example.demo.whiteship;

import java.util.Arrays;

public class Stack {

    private int[] arrays;
    private int size;

    public Stack() {
        arrays = new int[0];
        setSize(0);
    }

    public void push(int data){
        arrays = Arrays.copyOf(arrays, arrays.length + 1);
        arrays[arrays.length - 1] = data;
        setSize(arrays.length);
    }

    public int pop() {

        int result = arrays[ size - 1 ];
        arrays = Arrays.copyOfRange(arrays, 0, size - 1);
        setSize(arrays.length);
        return result;
    }

    private void setSize(int length) {
        size = length;
    }
}
