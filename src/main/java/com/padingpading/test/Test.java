//package com.padingpading.test;
//
///**
// * @author libin
// * @description
// * @date 2021/6/9
// */
//import java.io.Serializable;
//import java.util.ArrayList;
//
//public class RBTree<K extends Comparable<K>, V extends Serializable> {
//    private static final  boolean RED =true;
//    private static final  boolean BLACK =false;
//    private class Node {
//        public K key;
//        public V value;
//        public Node left, right;
//        public boolean  color;
//
//        public Node(K key, V value) {
//            this.key = key;
//            this.value = value;
//            left = null;
//            right = null;
//            //初始化为红色:在2-3树中，总是先去和结点进行融合的，然后再去变形。
//            color = RED;
//        }
//    }
//    private Node root;
//    private int size;
//
//    public RBTree() {
//        this.root = null;
//        this.size = 0;
//    }
//
//    //判断结点的颜色
//    //每一个叶子结点(最后䣌空结点)是黑色的。
//    private boolean isRed(Node node) {
//        if (node == null) {
//            return BLACK;
//        }
//        return node.color;
//    }
//
//    public V put(K key, V value) {
//        return null;
//    }
//
//
//
//
//    public int getSize() {
//        return size;
//    }
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    //颜色翻转:向2-3树三节点添加一个元素，变成四节点，需要变形成三个二节点，三个二节点都为黑色,
//    // 然后父节点去向上融合,此时的父节点为红色,两个子节点为黑色。
//    // node根，左右两个孩子颜色翻转
//    private void flipdColor(Node node){
//        node.color = RED;
//        node.left.color = BLACK;
//        node.right.color = BLACK;
//    }
//
//    //左旋转
//    private Node leftRotate(Node node){
//        Node right = node.right;
//        Node x = node.right;
//        x.left = right;
//        x.color = node.color;
//        node.color = RED;
//        return x;
//    }
//
//
//    //右旋转
//    private Node rightRotate(Node node){
//        Node x = node.left;
//        node.left = x.right;
//        x.right = node;
//        x.color = node.color;
//        node.color = RED;
//        return x;
//    }
//
//    //向红黑树中添加新的元素,返回红黑树的根。
//    public void add(K key, V value) {
//        root = add(root, key, value);
//        //最终的根结点为黑色。
//        root.color = BLACK;
//    }
//
//    private Node add(Node node, K key, V value) {
//        if (node == null) {
//            size++;
//            return new Node(key, value);
//        }
//        if (key.compareTo(node.key) < 0) {
//            node.left = add(node.left, key, value);
//        }
//        if (key.compareTo(node.key) > 0) {
//            node.right = add(node.right, key, value);
//        } else {
//            node.value = value;
//        }
//        //果右节点为红色,左节点为黑色, 那么进行左旋转, 对应情况2
//        if(isRed(node.right)&&!isRed(node.left))
//            node= leftRotate(node);
//        if(isRed(node.left)&&isRed(node.left.left))
//            node = rightRotate(node);
//        if(isRed(node.left)&&isRed(node.right))
//            flipdColor(node);
//        return node;
//    }
//
//
//
//    //判断该树是不是一颗二叉树
//    public boolean isBST() {
//        //通过中序遍历时,二分搜索树是有序的。
//        ArrayList<K> keys = new ArrayList<>();
//        inOrder(root, keys);
//        for (int i = 1; i < keys.size(); i++) {
//            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void inOrder(Node node, ArrayList<K> keys) {
//        if (null == node) {
//            return;
//        }
//
//        inOrder(node.left, keys);
//        keys.add(node.key);
//        inOrder(node.right, keys);
//    }
//
//
//    public static void main(String[] args) {
//        Integer[] arrs = {50, 13, 9, 98, 64, 75, 135, 7, 64, 1, 65, 8, 7, 3};
//        AVLTree<Integer, String> av = new AVLTree<>();
//        for (int i = 0; i < arrs.length; i++) {
//            av.add(arrs[i], "test");
//        }
//        System.out.println(av.isBST());
//        System.out.println(av.isBalanced());
//    }
//}
