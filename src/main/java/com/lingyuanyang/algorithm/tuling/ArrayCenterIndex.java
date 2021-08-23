package com.lingyuanyang.algorithm.tuling;

import java.util.Arrays;

public class ArrayCenterIndex {
    /*
     * 返回中心坐标，使得左右元素相加的值相等
     */
    public static void main(String[] args) {
        System.out.println(pivotIndex2(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int left_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            left_sum += nums[i];
            if (left_sum == sum) {
                return i;
            } else {
                sum = sum - nums[i];
            }
        }
        return -1;
    }

    public static int pivotIndex2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int left_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * left_sum + nums[i] == sum) {
                return i;
            } else {
                left_sum += nums[i];
            }
        }
        return -1;
    }
}
