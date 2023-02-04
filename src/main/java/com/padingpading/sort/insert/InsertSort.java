package com.padingpading.sort.insert;

import com.padingpading.sort.ArrayGenerator;
import com.padingpading.sort.SortingHelper;

/**
 * @author libin
 * @description
 * @date 2021/6/13
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] integers = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("InsertSort", integers);
        }
//        InsertSort,n=10000:0.104666 s
//        InsertSort,n=1000InsertSort00:13.700619 s
    }
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }

    }
    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
