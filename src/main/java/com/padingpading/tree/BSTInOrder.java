package com.padingpading.tree;

/**
 * @author libin
 * @description
 * @date 2021/6/27
 */
public class BSTInOrder<E extends Comparable<E>> {

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

    public BSTInOrder() {
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
    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node node) {
        if (null == node) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public int size() {
        return size;
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
}
