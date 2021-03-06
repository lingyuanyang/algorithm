package com.lingyuanyang.algorithm.tuling;

public class A9_ArrangeCoin {

    /*
     * 9.排列硬币
     * 总共有n枚硬币，第k行必须刚好有k枚硬币
     * 给定一个数字n，求出可形成完整梯形行的总行数
     */
    public static void main(String[] args) {
//        System.out.println(arrangeCoins(1000));
//        System.out.println(arrangeCoins1(1000));
//        System.out.println(arrangeCoins2(1000));
//        System.out.println(arrangeCoins3(1000));
        System.out.println(arrangeCoins4(1000));
    }

    /*
     * 解法一：迭代一
     */
    private static int arrangeCoins(int x) {
        int count = 0;
        for (int i = 1; ; i++) {
            count += i;
            if (count > x) {
                return i - 1;
            }
        }
    }

    /*
     * 解法二：迭代二
     */
    private static int arrangeCoins1(int x) {
        for (int i = 1; ; i++) {
            x = x - i;
            if (x <= i) {
                return i;
            }
        }
    }

    /*
     * 解法三：迭代三
     */
    private static int arrangeCoins2(int x) {
        for (int i = 1; ; i++) {
            if ((1 + i) * i / 2 > x) {
                return i - 1;
            }
        }
    }

    /*
     * 解法四：二分法
     */
    private static int arrangeCoins3(int x) {
        int low = 0;
        int high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cost = (1 + mid) * mid / 2;
            if (cost > x) {
                high = mid - 1;
            } else if (cost < x) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return high;
    }

    /*
     * 解法五：牛顿迭代
     * 实质为求取 （1 + n）* n / 2 = x 中的n的问题
     * 2x = n * n + n
     * 2x - n = n * n
     * n = (2x - n) / n
     * 转换为求取 n * n 平方根的问题
     */
    private static int arrangeCoins4(int n) {
        if (n == 0) {
            return 0;
        }
        return (int) sqrt(n, n);
    }

    /*
     * n 和 (2x - n) / n 分别为 n * n 的两个乘数
     */
    private static double sqrt(double x, int n) {
        double res = (x + ((2 * n - x) / x)) / 2;
        System.out.println("res=" + res);
        if (res == x) {
            return x;
        } else {
            return sqrt(res, n);
        }
    }
}
