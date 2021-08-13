package com.padingpading.sort.bubble;

/**
 * @author libin
 * @description
 * @date 2021-08-10
 */
public class BubbleSort {
    public BubbleSort() {

    }

    //优化:记录最后一次交换的位置,该位置后的元素实际已经排序好了
    public static <E extends Comparable<E>> void bubbleSort(E[] data) {
        for (int i = 0; i < data.length - 1; ) {
            int lastSwapIndex = 0;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    //记录后面那个位置
                    lastSwapIndex = j + 1;
                }
            }
            if (lastSwapIndex == 0) {
                break;
            }
            //跳过的轮数,根据lastSwapIndex确定。
            i = data.length - lastSwapIndex;
        }
    }

//    //通过标志位判断已经排排序好了
//    //优点:完全有序很好。
//    //缺点:无序时会做额外的开销。对于没有优化的排序,有序的性能也会提高,避免了swap的开销。
//    public static <E extends Comparable<E>> void bubbleSort(E[] data) {
//        for (int i = 0; i < data.length - 1; i++) {
//            boolean isSwap = false;
//            for (int j = 0; j < data.length - i - 1; j++) {
//                if (data[j].compareTo(data[j + 1]) > 0) {
//                    swap(data, j, j + 1);
//                    isSwap = true;
//                }
//            }
//            if (isSwap) {
//                break;
//            }
//        }
//    }

    //第一版
//    public static <E extends Comparable<E>> void bubbleSort(E[] data) {
//        for (int i = 0; i < data.length - 1; i++) {
//            for (int j = 0; j < data.length - i - 1; j++) {
//                if (data[j].compareTo(data[j + 1]) > 0) {
//                    swap(data, j, j+1);
//                }
//            }
//        }
//    }

    private static <E extends Comparable<E>> void swap(E[] data, int i, int j) {
        E ele = data[i];
        data[i] = data[j];
        data[j] = ele;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 23, 5, 6, 7, 8};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}