package com.example.demo.whiteship;

import java.util.Arrays;
import java.util.LinkedList;

public class Queue {
    public int[] arrays;
    private int size;

    public Queue() {
        arrays = new int[0];
        size = 0;
    }

    public void push(int data){

        arrays = Arrays.copyOf(arrays, arrays.length + 1);
        arrays[arrays.length - 1] = data;
        setSize(arrays.length);
    }

    public int peek() {

        int result = arrays[0];
        arrays = Arrays.copyOfRange(arrays, 1, size);
        setSize(arrays.length);
        return result;
    }

    private void setSize(int length) {
        size = length;
    }



}
