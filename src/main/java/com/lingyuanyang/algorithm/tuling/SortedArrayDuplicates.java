package com.lingyuanyang.algorithm.tuling;

public class SortedArrayDuplicates {
    /*
     * 双指针算法
     * 删除有序数组中的重复元素，返回删除后的数组长度
     */
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 1, 2, 2, 3, 3, 4, 4, 4, 5}));
    }

    public static int removeDuplicates(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < num.length; j++) {
            if (num[i] != num[j]) {
                i++;
                num[i] = num[j];
            }
        }
        return i + 1;
    }
}
