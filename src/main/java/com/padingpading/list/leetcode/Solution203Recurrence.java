package com.padingpading.list.leetcode;

import java.util.ResourceBundle;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution203Recurrence {
    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generrateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call:remove" + val + "in" + head);
        if (head == null) {
            System.out.print(depthString);
            return null;
        }
        head.next = removeElements(head.next, val, depth + 1);
        return head.val == val ? head.next : head;
    }

    private String generrateDepthString(int depth) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            str.append("--");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
    }


}

