package com.padingpading.list.leetcode;


public class ListNode {
    int val;
    public  ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode(int[] arr) {
        if(arr==null||arr.length==0){
            throw  new IllegalArgumentException("dfdf");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur!=null){
            sb.append(cur.val+"->");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
    }
}

