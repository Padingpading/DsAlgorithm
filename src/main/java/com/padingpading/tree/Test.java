package com.padingpading.tree;

import sun.swing.BakedArrayList;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author libin
 * @description
 * @date 2021-06-28
 */
public class Test {
//    public static void main(String[] args) {
//        BSTPostOrder <Integer> bst = new BSTPostOrder<>();
//        int[] nums = {5,3,6,8,4,2};
//        for (int num : nums) {
//            bst.add(num);
//        }
//        bst.postOrder();
//        //System.out.println();
//       // System.out.println(bst);
//    }

    public static void main(String[] args) {
        BST <Integer> bst = new BST<>();
        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> numbs = new ArrayList<>();
        while (!bst.isEmpty()){
            numbs.add(bst.removeMin());
        }
        System.out.println(numbs);
    }
}
