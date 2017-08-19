package com.island.mock.m0819;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UglyNumberII {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1680));
    }

    public static int nthUglyNumber(int n) {
        int[] uglyNumArray = new int[1681];
        uglyNumArray[0] = 1;
        uglyNumArray[1] = 2;
        uglyNumArray[2] = 3;
        uglyNumArray[3] = 4;
        uglyNumArray[4] = 5;
        uglyNumArray[5] = 6;
        uglyNumArray[6] = 8;
        uglyNumArray[7] = 9;
        uglyNumArray[8] = 10;
        uglyNumArray[9] = 12;
        int cursor = 9;
        Map<Integer, Integer> uglyNumMap = new HashMap<Integer, Integer>();
        uglyNumMap.put(1, 0);
        uglyNumMap.put(2, 1);
        uglyNumMap.put(3, 2);
        uglyNumMap.put(4, 3);
        uglyNumMap.put(5, 4);
        uglyNumMap.put(6, 5);
        uglyNumMap.put(8, 6);
        uglyNumMap.put(9, 7);
        uglyNumMap.put(10, 8);
        uglyNumMap.put(12, 9);

        int i = 6;
        int j = 4;
        int k = 2;

        while (true) {

            int[] list1 = new int[0];
            if (cursor - i + 1 > 0) {
                list1 = new int[cursor - i + 1];
                for (int list1i = 0; i <= cursor; i++, list1i++) {
                    list1[list1i] = uglyNumArray[i] * 2;
                }
            }

            int[] list2 = new int[0];
            if (cursor - j + 1 > 0) {
                list2 = new int[cursor - j + 1];
                for (int list2i = 0; j <= cursor; j++, list2i++) {
                    list2[list2i] = uglyNumArray[j] * 3;
                }
            }
            int[] list3 = new int[0];
            if (cursor - k + 1 > 0) {
                list3 = new int[cursor - k + 1];
                for (int list3i = 0; k <= cursor; k++, list3i++) {
                    list3[list3i] = uglyNumArray[k] * 5;
                }
            }

            int m1 = list1.length;
            int n1 = list2.length;
            int k1 = list3.length;
            Set<Integer> reSet = new HashSet<Integer>();
            for (int x = 0; x < m1; x++) {
                reSet.add(list1[x]);
            }
            for (int y = 0; y < n1; y++) {
                reSet.add(list2[y]);
            }
            for (int z = 0; z < k1; z++) {
                reSet.add(list3[z]);
            }
            int[] result = new int[reSet.size()];
            int mm1 = 0;
            for (Integer inter : reSet) {
                result[mm1] = inter;
                mm1++;
            }

            quickSort(result, 0, result.length - 1);

            cursor = mergeToUglyNumArray(result, uglyNumArray, cursor, uglyNumMap);
            if (cursor >= n - 1) {
                break;
            }

            i = uglyNumMap.get(list1[list1.length - 1]) + 1;
            j = uglyNumMap.get(list2[list2.length - 1]) + 1;
            k = uglyNumMap.get(list3[list3.length - 1]) + 1;

        }

        return uglyNumArray[n - 1];
    }

    private static void quickSort(int[] result, int m, int n) {
        if (m >= n) {
            return;
        }
        int i = m;
        int j = n;
        int key = result[i];
        while (i < j) {
            while (i < j && key < result[j]) {
                j--;
            }
            result[i] = result[j];
            while (i < j && key > result[i]) {
                i++;
            }
            result[j] = result[i];
        }
        result[i] = key;
        quickSort(result, m, i - 1);
        quickSort(result, i + 1, n);
    }

    private static int mergeToUglyNumArray(int[] newArray2, int[] uglyNumArray, int cursor,
            Map<Integer, Integer> uglyNumMap) {
        int m = newArray2.length;
        for (int i = 0; i < m && i + cursor + 1 < 1681; i++) {
            uglyNumArray[i + cursor + 1] = newArray2[i];
            uglyNumMap.put(newArray2[i], i + cursor + 1);
        }
        cursor = cursor + m;
        return cursor;
    }

}
