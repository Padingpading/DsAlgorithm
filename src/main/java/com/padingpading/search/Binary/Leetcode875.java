package com.padingpading.search.Binary;

import java.util.Arrays;

/**
 * @author libin
 * @description
 * @date 2021/6/27
 */
public class Leetcode875 {
    public int minEatingSpeed(int[] piles, int h) {
        int  l = 1;
        int  r  = Arrays.stream(piles).max().getAsInt();
        while(l<r){
            int mid = l+(r-l)/2;
            if(eatingTile(piles,mid)<=h){
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

    private int eatingTile(int[] piles, int k) {
        int res = 0;
        for (int pile : piles) {
            res +=pile/k+(pile%k>0?1:0);
        }
        return  res;
    }
}
