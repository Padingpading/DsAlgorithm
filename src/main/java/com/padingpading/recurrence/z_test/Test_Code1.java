package com.padingpading.recurrence.z_test;

public class Test_Code1 {

    public int max(int arr[],int L,int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R + L) >> 1);
        int maxLeft = max(arr, L, mid);
        int maxRight = max(arr, mid, R);
        return Math.max(maxLeft, maxRight);
    }
}
