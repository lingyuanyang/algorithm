package com.lingyuanyang.algorithm.tuling;

import java.util.Arrays;

public class A11_MergeSortArray {
    /*
     * 11.合并两个有序数组
     * 注意：返回nums1，不是新数组
     */
    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 5, 7, 9, 10, 0, 0, 0, 0};
        int[] nums2 = new int[]{2, 4, 6, 8};
//        System.out.println(Arrays.toString(merge(nums1, 5, nums2, 4)));
//        System.out.println(Arrays.toString(merge1(nums1, 5, nums2, 5)));
//        System.out.println(Arrays.toString(merge2(nums1, 5, nums2, 5)));
        System.out.println(Arrays.toString(merge3(nums1, 5, nums2, 4)));
    }

    /*
     * 解法一：利用System.arraycopy
     * 时间复杂度O(NlogN)
     * 空间复杂度O(1)
     */
    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        return nums1;
    }

    /*
     * 解法二：双指针
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     */
    private static int[] merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] new_nums = new int[m + n];
        for (int i = 0, j = 0; i + j < m + n; ) {
            int a;
            int b;
            a = i >= m ? Integer.MAX_VALUE : nums1[i];
            b = j >= n ? Integer.MAX_VALUE : nums2[j];
            if (a < b) {
                new_nums[i + j] = a;
                i++;
            } else {
                new_nums[i + j] = b;
                j++;
            }
        }
        return new_nums;
    }

    /*
     * 解法三：双指针
     * 时间复杂度O(M+N)
     * 空间复杂度O(N)
     */
    private static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 < m && p2 < n) {
            nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
        }
        if (p2 == n) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p1 == m) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
        return nums1;
    }

    /*
     * 解法四
     * 时间复杂度O(M+N)
     * 空间复杂度O(N)
     */
    private static int[] merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p1 + p2 + 1] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        return nums1;
    }
}
