/**
 * ymm56.com Inc. Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.ymm;

import java.util.Arrays;

/**
 * @author song.li
 * @date 2020/09/10
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }



}