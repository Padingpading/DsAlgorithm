package com.padingpading.stack;

import com.padingpading.list.LinkedList;
import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.security.PublicKey;

/**
 * @author libin
 * @description
 * @date 2021/6/19
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        this.list = new LinkedList<E>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        E e = list.removeFirst();
        return e;
    }

    @Override
    public E peak() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stack:top");
        stringBuilder.append(list);
        return stringBuilder.toString();
    }
}
