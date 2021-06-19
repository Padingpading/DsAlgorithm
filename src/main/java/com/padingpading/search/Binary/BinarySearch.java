package com.padingpading.search.Binary;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import jdk.internal.dynalink.support.DefaultInternalObjectFilter;

/**
 * @author libin
 * @description
 * @date 2021/6/17
 */
public class BinarySearch{

    public BinarySearch() {
    }


    public static <E extends  Comparable<E>> int search(E[] data,E target){


        return search(data,0,data.length-1,target);
    }

    private  static <E extends  Comparable<E>> int search(E[] data,int l,int r,E target){
        if(l>r) return -1;
//        int mid =
        return -1;
    }
}
