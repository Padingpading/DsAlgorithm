package com.padingpading.search.Binary;

/**
 * @author libin
 * @description
 * @date 2021/6/17
 */
public class Ceil {
    public Ceil() {
    }
    //>taget 返回最小值索引
    //==target 返回最大索引
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        int l = 0, r = data.length;
        //在data[l,r]中寻找解。
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else
                r = mid;
        }
        return l;
    }

    public static <E extends Comparable<E>> int ceil(E[] data, E target) {
        int u = upper(data, target);
        if (u - 1 > 0 && data[u - 1].compareTo(target) == 0)
            return u - 1;
        return u;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 3, 5, 5};
        for (int i = 0; i < 6; i++) {
            int upper = Ceil.ceil(arr, i);
            System.out.println(upper);
        }
    }
}
