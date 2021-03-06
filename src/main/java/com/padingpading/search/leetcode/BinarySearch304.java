package com.padingpading.search.leetcode;

/**
 * @author libin
 * @description
 * @date 2021/6/26
 */
public class BinarySearch304 {

    public int search(int[] nums, int target) {
        return  search(nums,0,nums.length,target);
    }

    private  int search(int[] data,int l,int r,int target){
        if(l>r) return -1;
        int mid = l +(r-l)/2 ;
        if(data[mid] == 0)
            return mid;
        if(data[mid] <0)
            return  search(data,mid+1,r,target);
        return  search(data,l,mid-1,target);
    }
}
