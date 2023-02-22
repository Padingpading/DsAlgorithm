//package com.padingpading.sort.meger;
//
//public class MergeSort_2 {
//
//    // 非递归方法实现
//    public static void mergeSort2(int[] arr) {
//        if (arr == null || arr.length < 2) {
//            return;
//        }
//        int N = arr.length;
//        //步长。log N
//        int mergeSize = 1;
//        //mergeSize每次扩大2,循环的次数未 2的n次<N  执行次数=log(n)
//        //总的复杂度为 logn * n
//        while (mergeSize < N) {
//            // 当前左组的第一个位置
//            int L = 0;
//            //如果步长 超过了数组最大值,跳出
//            while (L < N) {
//                //
//                if (mergeSize >= N - L) {
//                    break;
//                }
//                int M = L + mergeSize - 1;
//                int R = M + Math.min(mergeSize, N - M - 1);
//                merge(arr, L, M, R);
//                L = R + 1;
//            }
//            // 防止溢出
//            if (mergeSize > N / 2) {
//                break;
//            }
//            //每次在mergeSize扩大两倍。
//            mergeSize <<= 1;
//        }
//    }
//
//    public static void merge(int[] arr, int L, int M, int R) {
//        //辅助数组,大小为 要排序元素的的大小。 L->M>R
//        int[] help = new int[R - L + 1];
//        int i = 0;
//        //左侧最小元素。
//        int p1 = L;
//        //右侧最小元素。
//        int p2 = M + 1;
//        //循环比较,直到越界。
//        while (p1 <= M && p2 <= R) {
//            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
//        }
//        // 要么p1越界了，要么p2越界了,只会发生一个。
//        //p2越界。
//        while (p1 <= M) {
//            //拷贝剩余数据。
//            help[i++] = arr[p1++];
//        }
//        //p1越界。
//        while (p2 <= R) {
//            //拷贝剩余数据。
//            help[i++] = arr[p2++];
//        }
//        for (i = 0; i < help.length; i++) {
//            //拷贝进array中。
//            arr[L + i] = help[i];
//        }
//    }
//
//    public static void MergeSortNonR(int[] tmp) {
//        int n = tmp.length;
//        int gap = 1;
//        //外层循环，控制gap的值，gap每次增加二倍
//        while (gap < n) {
//            //n是数组元素个数
//            for (int i = 0; i < n; i += 2 * gap) {
//                //归并 [i,i+gap-1] [i+gab,i+2*gap-1]
//                int begin1 = i, end1 = i + gap - 1;
//                int begin2 = i + gap, end2 = i + 2 * gap - 1;
//                //处理边界值
//                //如果是 end1 越界或者 begin2 越界，直接退出即可，不需要归并
//                if (end1 >= n || begin2 >= n) {
//                    break;
//                }
//                //如果是 end2 越界。需要归并
//                if (end2 >= n) {
//                    end2 = n - 1;
//                }
//                //
////	            int mid = begin1 + ((end2 - begin1) >> 1);
////	            merge(tmp,begin1,mid,end2);
//                int index = i;
//                while (begin1 <= end1 && begin2 <= end2)
//                {
//                    if (a[begin1] < a[begin2])
//                    {
//                        tmp[index++] = a[begin1++];
//                    }
//                    else
//                    {
//                        tmp[index++] = a[begin2++];
//                    }
//                }
//                while (begin1 <= end1)
//                {
//                    tmp[index++] = a[begin1++];
//                }
//                while (begin2 <= end2)
//                {
//                    tmp[index++] = a[begin2++];
//                }
//
//                //小区间优化拷贝回数组a
//                for (int j = i; j <= end2; j++)
//                {
//                    a[j] = tmp[j];
//                }
//
//            }
//            gap *= 2;
//        }
//    }
//
//
//
//    // for test
//    public static int[] generateRandomArray(int maxSize, int maxValue) {
//        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
//        }
//        return arr;
//    }
//
//    // for test
//    public static int[] copyArray(int[] arr) {
//        if (arr == null) {
//            return null;
//        }
//        int[] res = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            res[i] = arr[i];
//        }
//        return res;
//    }
//
//    // for test
//    public static boolean isEqual(int[] arr1, int[] arr2) {
//        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
//            return false;
//        }
//        if (arr1 == null && arr2 == null) {
//            return true;
//        }
//        if (arr1.length != arr2.length) {
//            return false;
//        }
//        for (int i = 0; i < arr1.length; i++) {
//            if (arr1[i] != arr2[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    // for test
//    public static void printArray(int[] arr) {
//        if (arr == null) {
//            return;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//    }
//
//    // for test
//    public static void main(String[] args) {
//        int testTime = 500000;
//        int maxSize = 100;
//        int maxValue = 100;
//        System.out.println("测试开始");
//        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            //mergeSort2(arr2);
//	        MergeSortNonR(arr2);
//            if (!isEqual(arr1, arr2)) {
//                System.out.println("出错了！");
//                printArray(arr1);
//                printArray(arr2);
//                break;
//            }
//        }
//        System.out.println("测试结束");
//    }
//
//}
