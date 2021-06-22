package com.padingpading.sort.leetcode;


import com.padingpading.sort.ArrayGenerator;
import com.padingpading.sort.SortingHelper;

import java.util.Arrays;

/**
 * @author libin
 * @description
 * @date 2021/6/17
 */
public class LeetCode54 {

    public LeetCode54() {
    }


    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        //结束条件
        if (l >= r) return;
        //
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        if(arr[mid].compareTo(arr[mid+1])>0)
        merge(arr, l, mid, r);
    }


    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        //创建临时数组，从这个数组中拿数比较
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            //arr[i]和arr[j]
            //注:这里还有个l的偏移量
            if (i > mid) {
                //左边界大于中点,左边界的值已经在数组中
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                //超出右边界,只需要设置左边界的值
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                //那边都没有超出,两边的二元素比较。
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                i++;
            }
        }
    }


    public static void main(String[] args) {

        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("MergeSort", arr);

    }
}
