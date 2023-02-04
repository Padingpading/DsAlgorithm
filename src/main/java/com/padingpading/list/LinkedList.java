package com.padingpading.list;



/**
 * @author libin
 * @description 单向链表
 * @date 2021/6/17
 */
public class LinkedList<E> {
    //虚拟头结点
    private Node dummyHead;
    //大小
    int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }
    /**
     * 添加头元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0,e);
    }


    /**添加结点
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("参数错误");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    //遍历链表
    public E get(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("参数错误");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }
    //获取第一个元素
    public E getFirst(){
        return get(0);
    }
    //获得链表的最后一个远古三
    public E getLast(){
        return get(size-1);
    }
    //修改链表中的值
    public void set(int index,E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("参数错误");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e){
        Node cur =dummyHead.next;
        while (cur!=null){
            if(cur.e.equals(e)){
                return true;
            }
            cur =cur.next;
        }
        return false;
    }


    //删除
    public E remove(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("参数错误");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev =prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur!=null){
            res.append(cur+"->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size > 0;
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
