package com.lingyuanyang.algorithm.tuling;

public class A3_SortedArrayDuplicates {
    /*
     * 3.删除一个有序数组中的重复元素，使每个元素只出现一次，返回删除后的数组长度
     * 双指针算法
     * {0, 1, 2, 2, 3, 3, 4, 4, 4, 5} => {0, 1, 2, 3, 4, 5} => 6
     */
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 2, 2, 3, 3, 4, 4, 4, 5}));
    }

    public static int removeDuplicates(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < num.length; j++) {
            //如果前值和后值不相等，则都前进一步
            if (num[i] != num[j]) {
                i++;
                num[i] = num[j];
            }
            //否则（前值和后值相等），j指针进一步，i指针原地不动
        }
        return i + 1;
    }
}
