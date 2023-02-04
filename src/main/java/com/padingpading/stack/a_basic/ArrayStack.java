package com.padingpading.stack.a_basic;

import java.util.Arrays;

public class ArrayStack<T> {
    //默认大小
    private final int DEFAULT_SIZE = 2;
    //容器大小
    private int capacity;
    //容器每次扩容的大小
    private int capacityIncrement = 0;
    //容器
    private Object[] elementData;
    //元素大小
    private int size = 0;

    public ArrayStack() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    //入栈
    public void push(T ele) {
        //扩容
        this.ensureCapacity(size + 1);
        elementData[size++] = ele;
    }

    //出栈
    public T pop() {
        if (size == 0) {
            return null;
        }
        T value = (T) elementData[size - 1];
        //释放栈顶元素
        elementData[--size] = null;
        return value;
    }

    //扩容检验以及扩容
    private void ensureCapacity(int curSize) {
        //校验是否需要扩容
        if (curSize <= capacity) {
            //不需要扩容
            return;
        }
        if (capacityIncrement > 0) {
            //自定义大小扩容
        } else {
            System.out.println("扩容啦");
            while (curSize > capacity) {
                //capacity = capacoty<<1
                //扩容为原来的一倍
                capacity <<= 1;
            }
        }
        //老数组复制到新数组中
        elementData = Arrays.copyOf(elementData, capacity);
    }

    //获取栈顶元素
    public T getPeak() {
        if (size == 0) {
            return null;
        }
        return (T) elementData[size - 1];
    }

    //栈的大小
    public int length() {
        return size;
    }

    //栈是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = size - 1; i >= 0; i--) {
                sb.append(elementData[i].toString() + ", ");
            }
            sb.append("]");
            int length = sb.length();
            // 删除多余的“,”和空格
            return sb.delete(length - 3, length - 1).toString();
        }
    }
}


