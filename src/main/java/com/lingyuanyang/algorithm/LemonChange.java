package com.lingyuanyang.algorithm;

public class LemonChange {
    /*
     * 贪心算法的使用场景 -> 柠檬水找零
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
