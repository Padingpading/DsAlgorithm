package com.padingpading.sort.insert;

import com.padingpading.sort.ArrayGenerator;
import com.padingpading.sort.SortingHelper;

import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author libin
 * @description
 * @date 2021/6/13
 */
public class InsertSort2 {
    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr1 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("InsertSort2", arr1);
//            InsertSort,n=100000:14.144661 s
//            InsertSort2,n=100000:8.994257 s
            Integer[] arr3 = ArrayGenerator.generateOrderedArray(n);
            SortingHelper.sortTest("InsertSort2", arr3);

        }
    }
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E t = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }

    }
    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
