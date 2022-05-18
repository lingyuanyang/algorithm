package com.lingyuanyang.algorithm.tuling;

import java.util.Arrays;

public class A6_MaxProduct {
    /*
     * 6.在一个整数数组中找出三个数相乘的最大乘积(乘积不会超过最大int值)
     * 重点考察：线性扫描
     */
    public static void main(String[] args) {
        System.out.println(sort(new int[]{-2, -10, -3, -7, -10, -4, -10, 1}));
        System.out.println(getMaxMin(new int[]{-2, -10, -3, -7, -10, -4, -10, 1}));
    }

    /*
     * 解法一：线性扫描
     */
    private static int getMaxMin(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int curr : nums) {
            if (curr < min1) {
                min2 = min1;
                min1 = curr;
            } else if (curr < min2) {
                min2 = curr;
            }

            if (curr > max1) {
                max3 = max2;
                max2 = max1;
                max1 = curr;
            } else if (curr > max2) {
                max3 = max2;
                max2 = curr;
            } else if (curr > max3) {
                max3 = curr;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    /*
     * 解法二：排序
     * Arrays.sort(nums)
     */
    private static int sort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        //返回 最大三个正数 和 两个负数和一个最大整数 的最大值
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }
}
