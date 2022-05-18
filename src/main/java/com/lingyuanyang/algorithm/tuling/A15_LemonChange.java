package com.lingyuanyang.algorithm.tuling;

public class A15_LemonChange {
    /*
     * 15.贪心算法的使用场景二 -> 柠檬水找零
     *
     * 每杯柠檬水售价5美元，顾客支付的面值为5美元，10美元，20美元
     * 一开始手头没有零钱，如果能给每位顾客正确找零，返回true，否则返回false
     */
    public static void main(String[] args) {
        System.out.println(change(new int[]{5, 10, 5, 10, 5, 20}));

    }

    private static boolean change(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five < 1) {
                    return false;
                } else {
                    five--;
                    ten++;
                }
            } else {//20
                if (five >= 1 && ten >= 1) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
