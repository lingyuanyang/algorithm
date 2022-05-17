package com.lingyuanyang.algorithm.tuling;

public class A5_SqrtX {

    /*
     * 5.x的平方根
     * 在不使用sqrt(x)函数的情况下，得到x的平方根的整数部分
     */
    public static void main(String[] args) {
        int num = 567;
        System.out.println("求得值：" + newton(num));
        System.out.println("真实值：" + Math.sqrt(num));
    }

    /*
     * 解法一：暴力求解 O(n)
     */
    private static int binarySearch1(int x) {
        if (x < 2) {
            return x;
        }
        for (int i = 1; i < x; i++) {
            if (i * i <= x && (i + 1) * (i + 1) > x) {
                return i;
            }
        }
        return 0;
    }

    /*
     * 解法二：二分法
     */
    private static int binarySearch2(int x) {
        int index = -1;
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    /*
     * 解法三：牛顿迭代
     * x = n * n => n+?
     * x / n = n
     * (x / n + n) / 2 => n
     */
    private static int newton(int x) {
        return (int) sqrt(x, x);
    }

    /*
     * 迭代(x / n + n) / 2
     * x / n 和 n是x的两个乘数
     * (x / n + n) / 2 更接近于真实的平方根
     * 通过不断迭代使得n不断趋近于真实的平方根
     */
    private static double sqrt(double n, int x) {
        double res = (x / n + n) / 2;
        System.out.println("res=" + res);
        if (res == n) {
            return n;
        } else {
            return sqrt(res, x);
        }
    }
}
