package com.lingyuanyang.algorithm.tuling;

public class A14_MaxSeq {
    /*
     * 14.贪心算法的使用场景一 -> 最长连续递增序列
     *
     * 非排序数组中的最大连续升序数组,并返回该长度
     */
    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 3, 4, 3, 4, 5, 6, 7}));
    }

    private static int findLength(int[] nums) {
        int start = 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                start = i;
            }
            max = Math.max(i - start + 1, max);
        }
        return max;
    }
}
