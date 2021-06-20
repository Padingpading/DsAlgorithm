package com.padingpading.list.leetcode;

import com.padingpading.list.leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        while (head!=null &&head.val==val){
            ListNode delNode = head;
            head =head.next;
            delNode.next = null;
        }
        if(head==null){
            return null;
        }
        ListNode prev = head;
        while (prev.next!=null){
            if(prev.next.val==val){
                ListNode delNode = prev.next;
                prev.next =delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public ListNode removeElements1(ListNode head, int val) {
        while (head!=null &&head.val==val){
            head  = head.next;
        }
        if(head==null){
            return null;
        }
        ListNode prev = head;
        while (prev.next!=null){
            if(prev.next.val==val){
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next!=null){
            if(prev.next.val==val){
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}

