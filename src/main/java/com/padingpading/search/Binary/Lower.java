package com.padingpading.search.Binary;

/**
 * @author libin
 * @description
 * @date 2021/6/17
 */
public class Lower {
    public Lower() {
    }
    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int l = -1, r = data.length - 1;
        //在data[l,r]中寻找解。
        while (l < r) {
            //可能造成死循环，(r-l)/2 取的是下界，r和l相邻时l永远不变,所以取个上边界+1
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid;
            } else
                r = mid - 1;
        }
        return l;
    }
    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++) {
            int upper = Lower.lower(arr, i);
            System.out.print(upper + "   ");
        }
    }
}
