package com.padingpading.stack.b_achieve;


import java.util.Stack;

/**
 * leetcode 155
 * 1、获取栈中的最小值。
 * 双栈结构 实现获取最小值。
 */
public class GetMin_Stack {
    
    /**
     * 存储栈
     */
    private Stack<Integer> store;
    
    /**
     * 存储最小值的栈
     */
    private Stack<Integer> min;
    
    public GetMin_Stack() {
        store = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int value) {
        store.push(value);
        if (min.isEmpty()) {
            min.push(value);
        } else {
            if (value < min.peek()) {
                min.push(value);
            } else {
                min.push(min.peek());
            }
        }
    }
    
    public int pop() {
        if (store.isEmpty()) {
            throw new RuntimeException("已经空了");
        }
        min.pop();
        return store.pop();
    }
    
    public int getmin() {
        return this.min.peek();
    }
    
    public static void main(String[] args) {
        GetMin_Stack stack1 = new GetMin_Stack();
        stack1.push(3);
        System.out.println(stack1.getmin());
        stack1.push(4);
        System.out.println(stack1.getmin());
        stack1.push(1);
        System.out.println(stack1.getmin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getmin());
        System.out.println("=============");
    }
}
