package com.lingyuanyang.algorithm;

import java.util.Arrays;

public class MaxProduct {
    /*
     * 在一个整数数组中找出三个数组相乘的最大乘积
     */
    public static void main(String[] args) {
        System.out.println(sort(new int[]{-2, -10, -3, -7, -10, -4, -10, 1}));
        System.out.println(getMaxMin(new int[]{-2, -10, -3, -7, -10, -4, -10, 1}));
    }

    /*
     * 线性扫描
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
     * 排序
     */
    private static int sort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }
}
