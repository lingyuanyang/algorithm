package com.lingyuanyang.algorithm.tuling;


public class A12_AvgArray {

    /*
     * 12.子数组最大平均数
     * 给一个整数数组，找出平均数最大且长度为k的下标连续的子数组，并输出该最大平均数
     */
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 21, 3, 4, 5, 6, 7, 8}, 4));
    }

    /*
     * 双指针
     * 移动窗口 slide window
     */
    private static double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int curr_sum = 0;
        for (int i = 0; i < k; i++) {
            curr_sum += nums[i];
        }
        int sum = curr_sum;
        for (int i = 1; i <= len - k; i++) {
            curr_sum += nums[i + k - 1] - nums[i - 1];
            sum = Math.max(curr_sum, sum);
        }
        return 1.00 * sum / k;
    }
}