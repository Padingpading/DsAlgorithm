package com.padingpading.list;

/**
 * @author libin
 * @description
 * @date 2021/6/17
 */
public class SingleList<T> {

    //头节点
    private Node head;
    private int size;

    class Node {
        private T value;
        private Node next;

        //创建节点时赋值,当前节点的下一个指针为null
        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * 添加头节点
     * <p>
     * 1、头节点不存在，直接赋值
     * <p>
     * 2、头节点存在，将新的节点变为头节点的，原来的头节点指向现在的头节点
     */
    public void addHeadNode(T value) {
        //创建节点
        Node newNode = new Node(value);
        //如果头节点不存在，设置当前节点为头节点。
        if (head == null) {
            head = newNode;
            return;
        }
        //新节点next直接指向当前头头节点。
        //新节点变为头节点
        newNode.next = head;
        head = newNode;
    }

    /**
     * 添加节点到尾部
     *
     * @param value
     */
    public void addTailNode(T value) {
        //创建节点
        Node node = new Node(value);
        //如果节点是否存在,不存在直接放到头部

        if (null == head) {

            head = node;

            return;

        }

    //找到最后一个节点

        Node last = head;

        while (last.next != null) {

            last = last.next;

        }

    //将新节点放入最后一个节点的next

        last.next = node;

    }

    /**
     * 添加到指定位置
     *
     * @param value 值
     * @param index 集合位置
     */

    public void addNodeAtIndex(T value, int index) {
        //校验存放的位置
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
        //
        if (index == 0) {
            addHeadNode(value);
        } else if (index == size()) {
        //放入尾部
            addTailNode(value);
        } else {
            //插入中间位置
            Node node = new Node(value);
            int position = 0;
            Node cur = head;//标记当前节点
            Node pre = null;//记录当前位置节点
            while (cur != null) {
                if (position == index) {
                    node.next = cur;
                    pre.next = node;
                    return;
                }
                pre = cur;
                cur = cur.next;
                position++;
            }
        }
    }

    public void deleteNodeAtIndex(int index) {

//校验范围

        if (index < 0 || index > size() - 1) {

            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");

        }

//删除头节点

        if (index == 0) {

            head = head.next;

            return;

        }

//遍历结点

        Node cur = head;

        Node pre = null;

        int position = 0;

        while (cur != null) {

            if (index == position) {

                pre.next = cur.next;

//断开与节点的链接,jvm会回收

                cur.next = null;

                return;

            }

            pre = cur;

            cur = cur.next;

            position++;

        }

    }

    public void reverse() {

        Node cur = head;//当前节点

        Node pre = null;//标记当前节点的上一个节点。

        Node temp;

        while (cur != null) {

//保存当前节点的下一个节点,将上一个节点和当前节点置换

            temp = cur.next;

            cur.next = pre;

//pre、cur 继续后移

            pre = cur;

            cur = temp;

        }

        head = pre;

    }

    public int size() {

        int size = 0;

        if (head == null) {

            return size;

        }

        Node cur = head;

        while (cur != null) {

            cur = cur.next;

            size++;

        }

        return size;

    }

    @Override

    public String

    toString() {

        return "SingleTest{" +

                "head=" + head +

                '}';

    }

}
