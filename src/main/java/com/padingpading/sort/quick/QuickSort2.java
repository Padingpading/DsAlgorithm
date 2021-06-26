package com.padingpading.sort.quick;

import com.padingpading.sort.ArrayGenerator;
import com.padingpading.sort.SortingHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * @author libin
 * @description 快速排序
 * @date 2021/6/22
 */
public class QuickSort2 {
    private QuickSort2() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1,random);

    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
        if (l >= r) return;
        int p = partition(arr, l, r,random);
        sort(arr, l, p - 1,random);
        sort(arr, p + 1, r,random);
    }

    public static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        int  p  = l + random.nextInt(r- l + 1);
        swap(arr,l,p);
        int j = l;
        //arr[l+1...j]<v : arr[j+1....i]>v
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                //分界位前移
                j++;
                //将当前值和小于值交换
                swap(arr, i, j);
            }
        }
        //标定点放到了中间。
        swap(arr, l, j);
        return j;
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, 1);
        System.out.println(arr);
        SortingHelper.sortTest("QuickSort2", arr);
    }
}
