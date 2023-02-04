package com.padingpading.tree;

/**
 * @author libin
 * @description
 * @date 2021-08-22
 */
import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            int height = 1;
        }
    }

    private Node root;

    private int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        }
        if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        //更新heght
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        //计算平衡因子
        int balanceFactory = getBalanceFactory(node);
        if (Math.abs(balanceFactory) > 1) {
            System.out.println("balance");
        }
        //平衡维护
        //1、LL
        if (balanceFactory > 1 && getBalanceFactory(node.left) > 0) {
            return rightRotate(node);
        } else if (balanceFactory < -1 && getBalanceFactory(node.left) < 0) {
            //rr
            return leftRotate(node);
        }

        //lr
        if (balanceFactory > 1 && getBalanceFactory(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //rl
        if (balanceFactory < -1 && getBalanceFactory(node.left) > 0) {
            node.left = rightRotate(node.left);
            return leftRotate(node);
        }
        return node;
    }

    private Node leftRotate(Node y) {
        Node x = y.right;
        Node t3 = x.left;
        x.left = y;
        y.right = t3;
        //更新y和left的heght
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }


    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t3 = x.right;
        x.right = y;
        y.left = t3;
        //更新y和left的heght
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }


    private int getBalanceFactory(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    //判断该树是不是一颗二叉树
    public boolean isBST() {
        //通过中序遍历时,二分搜索树是有序的。
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    //判断以node为根的二叉树是不是一颗平衡二叉树
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactory = getBalanceFactory(node);
        if (Math.abs(balanceFactory) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (null == node) {
            return;
        }

        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }


    //
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return root.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else {
            if (node.left == null) {
                //待删除结点左子树为空的情况
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.left == null) {
                //待删除结点右子树为空的情况

                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            } else {
                //左右子树都不为空
                //Node successor = minium(node.right);
                Node successor = null;
                //删除最小的结点
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;
                node.left = node.right = null;

                retNode = successor;
            }
        }
        if(retNode==null){
            //删除的是叶子字节
            return null;
        }
        //更新heght
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        //计算平衡因子
        int balanceFactory = getBalanceFactory(retNode);
        if (Math.abs(balanceFactory) > 1) {
            System.out.println("balance");
        }
        //平衡维护
        //1、LL
        if (balanceFactory > 1 && getBalanceFactory(retNode.left) > 0) {
            return rightRotate(retNode);
        } else if (balanceFactory < -1 && getBalanceFactory(retNode.left) < 0) {
            //rr
            return leftRotate(retNode);
        }

        //lr
        if (balanceFactory > 1 && getBalanceFactory(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        //rl
        if (balanceFactory < -1 && getBalanceFactory(retNode.left) > 0) {
            retNode.left = rightRotate(retNode.left);
            return leftRotate(retNode);
        }
        return retNode;
    }


    private Node getNode(Node root, K key) {
        return null;
    }


    public static void main(String[] args) {
        Integer[] arrs = {50, 13, 9, 98, 64, 75, 135, 7, 64, 1, 65, 8, 7, 3};
        AVLTree<Integer, String> av = new AVLTree<>();
        for (int i = 0; i < arrs.length; i++) {
            av.add(arrs[i], "test");
        }
        System.out.println(av.isBST());
        System.out.println(av.isBalanced());
    }

}