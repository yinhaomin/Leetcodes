package com.island.mock.m0819;

public class UglyNumberII2 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1680));
    }

    public static int nthUglyNumber(int n) {
        int[] uglyNumArray = new int[1691];
        uglyNumArray[0] = 1;
        int cursor = 0;
        int p = 0, q = 0, k = 0;
        while (cursor <= n - 1) {
            int l1 = uglyNumArray[p] * 2;
            int l2 = uglyNumArray[q] * 3;
            int l3 = uglyNumArray[k] * 5;

            if (l1 <= l2 && l1 <= l3) {
                if (l1 > uglyNumArray[cursor]) {
                    p++;
                    cursor++;
                    uglyNumArray[cursor] = l1;
                } else {
                    p++;
                }
            }

            if (l2 <= l1 && l2 <= l3) {
                if (l2 > uglyNumArray[cursor]) {
                    q++;
                    cursor++;
                    uglyNumArray[cursor] = l2;
                } else {
                    q++;
                }
            }

            if (l3 <= l1 && l3 <= l1) {
                if (l3 > uglyNumArray[cursor]) {
                    k++;
                    cursor++;
                    uglyNumArray[cursor] = l3;
                } else {
                    k++;
                }
            }

        }
        return uglyNumArray[n - 1];
    }

}
