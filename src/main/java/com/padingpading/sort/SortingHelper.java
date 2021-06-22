package com.padingpading.sort;

import com.padingpading.sort.insert.InsertSort2;
import com.padingpading.sort.meger.MergeSort;

import java.sql.Time;

/**
 * @author libin
 * @description
 * @date 2021/6/13
 */
public class SortingHelper {

    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for (int i = 1; i < arr.length-1; i++) {
            if(arr[i-1].compareTo(arr[i])>0){
                return false;
            }
        }
        return true;
    }

    public  static  <E extends Comparable<E> > void sortTest(String sortName, E[] arr){
        long startTime = System.nanoTime();
        if(sortName.equals("InsertSort2")){
            InsertSort2.sort(arr);
        } else if(sortName.equals("MergeSort")) {
            int sort = MergeSort.sort(arr);
            System.out.println(sort);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        if(!SortingHelper.isSorted(arr))
            throw new RuntimeException("SelectionSort failed");
        System.out.println(String.format("%s,n=%d:%f s",sortName,arr.length,time));
    }
}
