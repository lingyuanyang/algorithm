package com.lingyuanyang.algorithm;

import java.util.Arrays;

public class MergeSortArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 5, 7, 9, 0, 0, 0, 0};
        int[] nums2 = new int[]{2, 4, 6, 8};
        System.out.println(Arrays.toString(merge(nums1, 5, nums2, 4)));
    }

    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        return nums1;
    }
}
