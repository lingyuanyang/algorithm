package com.lingyuanyang.algorithm.tuling;

import java.util.Arrays;

public class A4_ArrayCenterIndex {
    /*
     * 4.返回中心坐标，使得左右元素相加的值相等
     * 如果数组不存在中心下标，则返回-1，如果存在多个则返回最左边的那个
     *
     * 求数组的和 => Arrays.stream(nums).sum()
     */
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int left_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            left_sum += nums[i];
            System.out.println(left_sum + "==" + sum);
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
