package com.padingpading.sort.selection;

import java.util.Collection;

/**
 * @author libin
 * @description
 * @date 2021/6/12
 */
public class Selection2 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("alice",123),
                new Student("bob",1223),
                new Student("jack",142)
        };
        selection(students);
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }

    private static <E extends Comparable<E>> void selection(E[] arr) {
        for (int i = 0; i < arr.length; i++) {//length
            //索引值当前循环的最大或最小索引,是由compareTo方法决定的
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[index]) < 0)//lending-i
                    index = j;
            }
            swap(arr, i, index);
        }
    }
    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
