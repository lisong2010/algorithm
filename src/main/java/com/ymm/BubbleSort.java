/**
 * ymm56.com Inc. Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.ymm;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author song.li
 * @date 2020/09/11
 */
public class BubbleSort {

    public static void sort(int[] array) {
        int t = 0;
        for (int i = 0; i < array.length - 1; i++) {
            t++;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {

                    swap(array, j, j + 1);
                }
                t++;
            }
        }

        System.out.println("sort calculate count: " + t);
    }

    public static void sort2(int[] array) {
        int t = 0;
        for (int e = array.length - 1; e > 0; e--) {
            t++;
            for (int i = 0; i < e; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
                t++;

            }
        }
        System.out.println("sort2 calculate count: " + t);
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * for test
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * for test
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random() ->  [0,1) 所有的小数，等概率返回一个
        // Math.random() * N -> [0,N) 所有小数，等概率返回一个
        // (int)(Math.random() * N) -> [0,N-1] 所有的整数，等概率返回一个
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())]; // 长度随机
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random())
                    - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        // 随机数组的长度0～100
        int maxSize = 100;
        // 值：-100～100
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            sort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                // 打印arr1
                // 打印arr2
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        sort(arr);
        printArray(arr);
    }
}