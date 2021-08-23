package com.lingyuanyang.algorithm.tuling;

public class PrimeNumber {

    //暴力枚举
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

    //埃拉托色尼筛选法(the Sieve of Eratosthenes)简称埃氏筛法
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

    public static void main(String[] args) {
        System.out.println(eratosthenes(100));
    }
}
