package com.algorithm.stack.arraystack;

public class Main {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack();

        for (int i=0; i<5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }

        arrayStack.pop();
        System.out.println(arrayStack);
    }
}
