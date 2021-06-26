package com.padingpading.sort.quick;

import com.padingpading.sort.ArrayGenerator;
import com.padingpading.sort.SortingHelper;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

/**
 * @author libin
 * @description 双路快速排序
 * @date 2021/6/22
 */
public class QuickSort4 {
    private QuickSort4() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1,random);

    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
        if (l >= r)   return;
        int p = partition(arr, l, r,random);
        sort(arr, l, p - 1,random);
        sort(arr, p + 1, r,random);
    }

    public static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        int  p  = l + random.nextInt(r- l + 1);
        swap(arr,l,p);
        //darr[l+1...i-1]<=v; arr[j+1....r]>=v
        int i = l+1;
        int j = r;
        while (true){
            while (i<=j&&arr[i].compareTo(arr[l])<0){
                i++;
            }
            while (j>=i&&arr[j].compareTo(arr[l])>0) {
                j--;
            }
            if(i>=j){
                break;
            }
            swap(arr,j,i);
            i++;
            j--;
        }
        swap(arr, l,j);
        return j;
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("QuickSort",arr);
        SortingHelper.sortTest("QuickSort4",arr2);
        Integer[] arr1 = ArrayGenerator.generateRandomArray(n,1);
        SortingHelper.sortTest("QuickSort4",arr1);
    }
}
