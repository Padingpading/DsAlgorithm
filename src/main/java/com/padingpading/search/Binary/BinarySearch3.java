package com.padingpading.search.Binary;

/**
 * @author libin
 * @description 循环不变量
 * @date 2021/6/17
 */
public class BinarySearch3 {
    public BinarySearch3() {
    }
    public static <E extends  Comparable<E>> int search(E[] data,E target){
        int l = 0, r=data.length;
        //在data[l,r)的范围查找target
        while (l<r){
            int mid = l+(r-l)/2;
            if(data[mid].compareTo(target)==0)
                return mid;
            if(data[mid].compareTo(target)<0)
                l = mid +1;
            else
                r = mid;
        }
        return -1;
    }
}
