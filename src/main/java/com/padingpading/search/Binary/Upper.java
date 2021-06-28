package com.padingpading.search.Binary;

import javax.swing.*;

/**
 * @author libin
 * @description
 * @date 2021/6/17
 */
public class Upper {
    public Upper() {
    }
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        int l = 0, r = data.length;
        //在data[l,r]中寻找解。
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else
                r = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 3, 5, 5};
        for (int i = 0; i < 6; i++) {
            int upper = Upper.upper(arr, i);
            System.out.println(upper);
        }
    }
}
