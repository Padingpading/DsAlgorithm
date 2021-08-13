package com.padingpading.list.reverse;

import com.padingpading.list.leetcode.ListNode;

import java.util.List;

/**
 * @author libin
 * @description
 * @date 2021-08-10
 */
public class ReverseLink {

    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            //更换指针。
            pre = cur;
            cur = next;
        }
        return  pre;
    }

    public ListNode reverseListDiGui(ListNode head){
        if(head ==null || head.next==null){
            return head;
        }
        ListNode rev = reverseListDiGui(head.next);
        head.next.next = head;
        head.next = null;
        return  rev;
    }

    public static void main(String[] args) {



    }
}
