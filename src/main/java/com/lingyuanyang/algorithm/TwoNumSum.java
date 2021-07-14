package com.lingyuanyang.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumSum {
    /*
     * 在一个数组中找出两个数的下标，保证该两数的和为目标值
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 7, 8}, 6)));
        System.out.println(Arrays.toString(solution1(new int[]{1, 2, 3, 4, 7, 8}, 6)));
        System.out.println(Arrays.toString(solution2(new int[]{1, 2, 3, 4, 7, 8}, 6)));
    }

    /*
     * 暴力循环
     * 时间复杂度 O(N2)
     */
    private static int[] solution(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /*
     * 优化
     * 时间复杂度 O(N)
     */
    private static int[] solution1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


    /*
     * 排序数组
     * 时间复杂度 O(NlogN)
     */
    private static int[] solution2(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int value = target - nums[i];
            int left = i;
            int right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == value) {
                    return new int[]{i, mid};
                } else if (nums[mid] > value) {
                    left++;
                    right = mid - 1;
                } else if (nums[mid] < value) {
                    left = mid + 1;
                    right--;
                }
            }
        }
        return null;
    }
}
