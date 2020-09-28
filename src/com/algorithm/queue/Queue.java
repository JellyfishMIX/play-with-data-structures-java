package com.algorithm.queue;

public interface Queue<E> {
    int getSize();
    boolean isEmpty();

    /**
     * 入队
     *
     * @param e element
     */
    void enqueue(E e);

    /**
     * 出队。Get the element at the head of the queue and remove it from the queue.
     * @return element at the head of the queue.
     */
    E dequeue();

    /**
     * 获取队首元素。Get the element at the head of the queue but not remove it from the queue.
     * @return element at the head of the queue.
     */
    E getFront();
}
