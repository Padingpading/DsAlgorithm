package com.padingpading.sort.quick;

import com.padingpading.sort.ArrayGenerator;
import com.padingpading.sort.SortingHelper;
import com.padingpading.sort.selection.Selection;

import java.util.Arrays;
import java.util.Random;

/**
 * @author libin
 * @description 三路快速排序
 * @date 2021/6/22
 */
public class QuickSort5 {
    private QuickSort5() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) return;
        int p = l + new Random().nextInt(r - l + 1);
        swap(arr, l, p);
        //arr[l+1,lt]<v  arr[lt+1,i-1]=v arr[gt,r]>v 初值都是空区间
        int lt = l;
        int i = l + 1;
        int gt = r + 1;
        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, i, gt);
            } else {
                i++;
            }
        }
        swap(arr, l, lt);
        //arr[l,lt-1]<v   arr[lt,g-1]=v arr[gt,r]>v 初值都是空区间
        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }


    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, 1);
        SortingHelper.sortTest("QuickSort5", arr);
    }
}
