package com.lingyuanyang.algorithm.tuling;

public class A2_PrimeNumber {

    /*
     * 2.统计素数的个数
     * 统计n以内的素数的个数
     * 重点考察：埃筛法
     */
    public static void main(String[] args) {
        System.out.println(eratosthenes(100));
    }


    /*
     * 解法一：暴力枚举
     */
    public static int bf(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    public static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    /*
     * 埃拉托色尼筛选法(the Sieve of Eratosthenes)简称埃氏筛法
     */
    public static int eratosthenes(int n) {
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                /*
                 * j = 2 * i -> j = i * i
                 */
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }
}
