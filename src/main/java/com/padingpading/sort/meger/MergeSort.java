package com.padingpading.sort.meger;


import com.padingpading.sort.ArrayGenerator;
import com.padingpading.sort.SortingHelper;

import java.util.Arrays;

/**
 * 归并排序。
 */
public class MergeSort {

    public MergeSort() {
    }

    public static <E extends Comparable<E>> int sort(E[] arr) {
        return sort(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> int sort(E[] arr, int l, int r) {
        //结束条件
        if (l >= r) return 0;
        //
        int res = 0;
        int mid = l + (r - l) / 2;
        res+= sort(arr, l, mid);
        res+= sort(arr, mid + 1, r);
        if(arr[mid].compareTo(arr[mid+1])>0)
            res+=merge(arr, l, mid, r);
        return res;
    }


    private static <E extends Comparable<E>> int merge(E[] arr, int l, int mid, int r) {
        //创建临时数组，从这个数组中拿数比较
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        int res = 0;
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
                res = mid-i+1;
                arr[k] = temp[j - l];
                i++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("MergeSort", arr);
    }
}
