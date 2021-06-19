package com.padingpading.stack;

/**
 * @author libin
 * @description
 * @date 2021/6/19
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e) ;
    E pop();
    E peak();
}
