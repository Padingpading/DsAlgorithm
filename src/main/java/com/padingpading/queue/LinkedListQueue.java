package com.padingpading.queue;

/**
 * @author libin
 * @description
 * @date 2021/6/19
 */
public class LinkedListQueue<E> implements Queue<E> {

    private Node head,tail;

    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public void enqueue(E e) {
        if(tail==null) {
            tail = new Node(e);
            head = tail;
        } else {
            Node addNode = new Node(e);
            tail.next = addNode;
            tail = addNode;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw  new IllegalArgumentException("empty");
        }
        Node retNode =head;
        head =head.next;
        retNode.next = null;
        if( retNode.e==null){
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue:front");

        Node cur = head;
        while (cur!=null){
            res.append(cur+"->");
            cur = cur.next;
        }
        res.append("null tail");
        return res.toString();
    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
