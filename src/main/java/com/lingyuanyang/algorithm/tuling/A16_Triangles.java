package com.lingyuanyang.algorithm.tuling;

import java.util.Arrays;

public class A16_Triangles {
    /*
     * 16.贪心算法的使用场景三 -> 求三角形的最大周长
     *
     * 在一个数组里找出任意三个能组成三角形边长的三个数，求满足周长最大
     *
     * 贪心算法的思想即为在需要满足多个条件时优先确保某一个条件优先成立
     */
    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{3, 6, 2, 3}));
    }

    private static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}
