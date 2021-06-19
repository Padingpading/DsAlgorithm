package com.padingpading.queue;

/**
 * @author libin
 * @description
 * @date 2021/6/19
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
