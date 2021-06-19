package com.padingpading.queue;

import com.padingpading.stack.LinkedListStack;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * @author libin
 * @description
 * @date 2021/6/19
 */
public class Test {

    public static void main(String[] args) {
        TestLinkedListQueue();
    }

    public static void TestLinkedListQueue() {
        LinkedListQueue<Integer> list = new LinkedListQueue<Integer>();
        for (int i = 0; i < 5; i++) {
            list.enqueue(i);
            System.out.println(list);
        }
        list.dequeue();
        System.out.println(list);
        list.dequeue();
        System.out.println(list);
        list.dequeue();
        System.out.println(list);
    }
}
