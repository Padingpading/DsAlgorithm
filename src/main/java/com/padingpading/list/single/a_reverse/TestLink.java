package com.padingpading.list.single.a_reverse;


import com.padingpading.list.Node;

import java.util.ArrayList;

public class TestLink {
    
    public static void main(String[] args) {
        Node node = generateRandomLinkedList(10, 4);
        ArrayList<Integer> integers = printListFromTailToHead(node);
        System.out.println(integers);
        
        //翻转链表
//        Node node1 = reverseLinkArray(node);
//        ArrayList<Integer> reverse = printListFromTailToHead(node1);
//        System.out.println(reverse);
        
        //删除节点数据
        Node removeNode = removeValue(node,1);
        ArrayList<Integer> removeArray = printListFromTailToHead(removeNode);
        System.out.println(removeArray);
    }
    
    /**
     * 翻转链表循环
     */
    public static Node reverseLink(Node head){
        Node pre = null;
        Node next = null;
        while (head !=null){
            next= head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    
    /**
     * 翻转链表对数组
     */
    public static Node reverseLinkArray(Node head){
        if(head==null){
            return null;
        }
        ArrayList<Node> array  = new ArrayList<>();
        while (head != null){
            array.add(head);
            head =  head.next;
        }
//        Node cur  = array.get(0);
//        cur.next  = null;
//        for (int i = 1; i < array.size(); i++) {
//            Node node = array.get(i);
//            node.next = cur;
//            cur  = node;
//        }
        Node cur  = array.get(0);
        cur.next  = null;
        for (int i = 1; i < array.size(); i++) {
            array.get(i).next = array.get(i-1);
        }
        return array.get(array.size()-1);
    }
    
    /**
     * 删除指定值的节点
     */
    public static Node removeValue(Node head, int num) {
        // head来到第一个不需要删的位置
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        // 1 ) head == null 链表中全部为 删除的值.
        // 2 ) head != null 链表中部分为 删除的值
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
    
    
    public static ArrayList<Integer> printListFromTailToHead(Node listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Node tmp = listNode;
        while(tmp!=null){
            list.add(0, tmp.value);
            tmp = tmp.next;
        }
        return list;
    }
    
    // for test
    public static Node generateRandomLinkedList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        Node head = new Node((int) (Math.random() * (value + 1)));
        Node pre = head;
        while (size != 0) {
            Node cur = new Node((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }
    
}


