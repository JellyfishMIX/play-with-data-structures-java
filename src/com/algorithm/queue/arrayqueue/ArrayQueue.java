package com.algorithm.queue.arrayqueue;

import com.algorithm.array.Array;
import com.algorithm.queue.Queue;

public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    // 构造方法
    public ArrayQueue() {
        array = new Array<>();
    }
    public ArrayQueue(int capacity) {
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

    @Override
    // 入队
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    // 出队
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    // 获取队首元素
    public E getFront() {
        return array.get(0);    // 判断栈是否为空的逻辑在Array中
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append("Queue: ");
        res.append("front [");
        for (int i=0; i<array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize()-1) {
                res.append(", ");
            }
        }
        res.append("] tail");

        return res.toString();
    }
}
