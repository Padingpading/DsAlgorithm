package com.padingpading.tree;

import javax.lang.model.util.ElementScanner6;

/**
 * @author libin
 * @description
 * @date 2021/6/27
 */
public class BST<E extends Comparable<E>> {

    private Node root;
    private int size;

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    public BST() {
        root = null;
        size = 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    //添加元素-递归
    private Node add(Node node, E e) {
        //插入的值存在
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    //查询元素是否存在-递归调用
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (null == node) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //add 第一版
//    private void add1(Node node, E e) {
//        //插入的值存在
//        if (e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else {
//            add(node.right.e);
//        }
//    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node node) {
        if (null == node) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (null == node) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }


    //寻找二分搜索树最大的元素
    public E minNum(){
        if(size==0){
            throw new  IllegalArgumentException("bst is empty");
        }
        return minNum(this.root).e;
    }

    public Node minNum(Node node){
        if(node.left==null){
            return node;
        }
        return minNum(node.left);
    }

    //寻找二分搜索树最大的元素
    public E maxNum(){
        if(size==0){
            throw new  IllegalArgumentException("bst is empty");
        }
        return maxNum(this.root).e;
    }

    public Node maxNum(Node node){
        if(node.right==null){
            return node;
        }
        return maxNum(node.right);
    }


    //删除二分搜索树的最小值
    public E removeMin(){
        E ret = minNum();
        root = removeMin(root);
        return ret;
    }
    //删除node为根的二分搜索树的最小结点
    //返回删除结点后新的二分搜索树的根
    public Node removeMin(Node node){
        if(node.left==null){
            Node rightNode = node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //删除二分搜索树的最小值
    public E removeMax(){
        E ret = minNum();
        root = removeMax(root);
        return ret;
    }
    //删除node为根的二分搜索树的最小结点
    //返回删除结点后新的二分搜索树的根
    public Node removeMax(Node node){
        if(node.right==null){
            Node rightNode = node.left;
            node.left=null;
            size--;
            return rightNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    //删除任意元素
    public void remove(E e){
        root = remove(root,e);
    }

    private Node remove(Node node, E e) {
        if(node==null){
            return null;
        }
        if(e.compareTo(node.e)<0){
            node.left =  remove(node.left,e);
            return node;
        } else if(e.compareTo(node.e)>0){
            node.right = remove(node.right,e);
            return node;
        } else {
            if(node.left==null){
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            if(node.right==null){
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }
            Node successor = minNum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }


}
