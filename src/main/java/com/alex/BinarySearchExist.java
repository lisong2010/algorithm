package com.alex;

import java.util.Arrays;

/**
 * @author song.li
 * @date 2020/09/14
 */
public class BinarySearchExist {

    public static boolean exist(int[] array, int num) {
        if (array == null || array.length == 0) {
            return false;
        }
        if (array.length == 1) {
            return array[0] == num;
        }

        int L = 0;
        int R = array.length - 1;
        int mid = 0;

        while (L < R) {
            mid = L + (R - L) / 2;

            if (array[mid] == num) {
                return true;
            }
            if (array[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return array[L] == num;
    }

    // for test
    public static boolean test(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }


    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != exist(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}