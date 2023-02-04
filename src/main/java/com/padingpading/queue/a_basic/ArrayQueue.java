package com.padingpading.queue.a_basic;

/**
 * @author libin
 * @description
 * @date 2021/6/14
 */
public class ArrayQueue<T> {

    private Object[] ele;

    private int size;

    private int rear;

    private int front;

    public ArrayQueue(int size) {
        this.size = size;
        this.ele = new Object[size];
    }

    //入队
    public void in(T t) throws Exception {
        if (rear == size) {
            throw new Exception("队列已满异常");
        }
        ele[rear++] = t;
    }

    //出队
    public T out() throws Exception {
        if (isEmpty()) {
            throw new Exception("空队列异常");
        }
        T o = (T) ele[front];
        ele[front++] = null;
        return o;
    }

    /**
     * 遍历队
     */
//    public void traverse() {
//        for (int i = front; i<
//        System.out.println("" + ele[i]);
//    }

    //是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    public static void main(String[] args) throws Exception {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>(10);
        arrayQueue.in(2);
        arrayQueue.in(3);
        arrayQueue.in(4);
        System.out.println(arrayQueue.out());
        System.out.println(arrayQueue.out());
        System.out.println(arrayQueue.out());
        arrayQueue.in(4);
        arrayQueue.in(4);
        arrayQueue.in(4);
        arrayQueue.in(4);
        System.out.println(arrayQueue.out());
        System.out.println(arrayQueue.out());
        System.out.println(arrayQueue.out());
        System.out.println(arrayQueue.out());
        arrayQueue.in(4);
        arrayQueue.in(4);
        arrayQueue.in(4);
        arrayQueue.in(4);
        arrayQueue.in(4);
        arrayQueue.in(4);
        System.out.println(arrayQueue.out());
        System.out.println(arrayQueue.out());
        System.out.println(arrayQueue.out());
        System.out.println(arrayQueue.out());
        System.out.println(arrayQueue.out());
        System.out.println(arrayQueue.out());
        System.out.println(arrayQueue.rear);
        System.out.println(arrayQueue.front);
    }
}