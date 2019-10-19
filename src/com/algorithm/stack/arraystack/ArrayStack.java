package com.algorithm.stack.arraystack;

import com.algorithm.array.Array;
import com.algorithm.stack.Stack;

public class ArrayStack<E> implements Stack<E> {
    Array<E> array; // 动态数组Array，capacity随意

    public ArrayStack() {
        array = new Array<>();
    }
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    // getCapacity()是动态数组Array实现Stack所特有的，Stack本身没有该方法。因为只有动态数组才有capacity这一概念
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    // 入栈
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    // 出栈
    public E pop() {
        return array.deleteLast();
    }

    @Override
    // 检查栈顶元素
    public E peek() {
        return array.getLast(); // 判断栈是否为空的逻辑在Array中
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for(int i = 0; i<array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize()-1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
