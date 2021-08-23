package com.lingyuanyang.algorithm.tuling;

public class Fibonacci {

    /*
     * 1 2 3 4 5 6 7 8
     * 1 1 2 3 5 8 13 21
     */
    public static void main(String[] args) {
        System.out.println(calculate(10));
        System.out.println(calculate2(10));
        System.out.println(iterate(10));
    }

    /*
     * 递归
     * 时间复杂度O(N)
     */
    private static long calculate(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        return calculate(x - 1) + calculate(x - 2);
    }

    /*
     * 去重递归
     * 时间复杂度O(N)
     */
    private static long calculate2(int x) {
        long[] arr = new long[x + 1];
        return recursive(arr, x);
    }

    private static long recursive(long[] arr, int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if (arr[x] != 0) {
            return arr[x];
        }
        arr[x] = recursive(arr, x - 1) + recursive(arr, x - 2);
        return arr[x];
    }

    /*
     * 双指针迭代
     * 时间复杂度O(N)
     */
    private static long iterate(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int l = 0;
        int r = 1;
        for (int i = 2; i < x + 1; i++) {
            int sum = l + r;
            l = r;
            r = sum;
        }
        return r;
    }
}
