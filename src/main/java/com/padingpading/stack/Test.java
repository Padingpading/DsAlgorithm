package com.padingpading.stack;

import com.padingpading.stack.a_basic.LinkedListStack;

/**
 * @author libin
 * @description
 * @date 2021/6/19
 */
public class Test {

    public static void main(String[] args) {
        testLinkedListStack();
    }

    public static void testLinkedListStack() {
        LinkedListStack<Integer> list = new LinkedListStack<Integer>();
        for (int i = 0; i < 5; i++) {
            list.push(i);
            System.out.println(list);
        }
        list.pop();
        System.out.println(list);

    }
}
