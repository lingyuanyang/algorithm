package com.lingyuanyang.algorithm.leetcode;

import java.util.Arrays;

public class GetMaximumInGeneratedArray {
    /*
     *给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
     * nums[0] = 0
     * nums[1] = 1
     * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
     * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
     * 返回生成数组 nums 中的 最大 值。
     */
    public static void main(String[] args) {
        int n = 7;
//        System.out.println(getMaximumGenerated(n));
        System.out.println(getMaximumGeneratedPlus(n));
    }

//    private static int getMaximumGenerated(int n) {
//        int[] nums = new int[n + 1];
//        if (n == 0) {
//            nums[0] = 0;
//        }
//        if (n == 1) {
//            nums[0] = 0;
//            nums[1] = 1;
//        }
//        if (n > 1) {
//            nums[0] = 0;
//            nums[1] = 1;
//            for (int i = 1; 2 * i <= n; i++) {
//                if (2 <= 2 * i && 2 * i <= n) {
//                    nums[2 * i] = nums[i];
//                }
//                if (2 <= 2 * i + 1 && 2 * i + 1 <= n) {
//                    nums[2 * i + 1] = nums[i] + nums[i + 1];
//                }
//            }
//        }
//        Arrays.sort(nums);
//        return nums[n];
//    }

    private static int getMaximumGeneratedPlus(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; ++i) {
            nums[i] = nums[i / 2] + i % 2 * nums[i / 2 + 1];
        }
        return Arrays.stream(nums).max().getAsInt();
    }
}
