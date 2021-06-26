package com.padingpading.search.Binary;

import javax.imageio.metadata.IIOMetadataNode;

/**
 * @author libin
 * @description 非递归实现
 * @date 2021/6/17
 */
public class BinarySearch2 {
    public BinarySearch2() {
    }
    public static <E extends  Comparable<E>> int search(E[] data,E target){
        int l = 0, r=data.length-1;
        //在data[l,r]的范围查找target
        while (l<=r){
            int mid = l+(r-l)/2;
            if(data[mid].compareTo(target)==0)
                return mid;
            if(data[mid].compareTo(target)<0)
                l = mid +1;
            else
                r = mid - 1;
        }
        return -1;
    }
}
