package com.padingpading.sort.selection;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import javax.swing.*;

/**
 * @author libin
 * @description
 * @date 2021/6/12
 */
public class Selection {
    public static void main(String[] args) {
        int[] arr = {1,4,2,3,6,5};
        selection(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
    }
    private static void  selection(int[] arr){
        for (int i = 0; i < arr.length; i++) {//length
            int maxIndex = i;
            for (int j = i; j < arr.length ; j++) {
                if(arr[j]>arr[maxIndex])//lending-i
                    //大到小,直接修改为<
                    maxIndex = j;
            }
            swap(arr,i,maxIndex);
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int t= arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
