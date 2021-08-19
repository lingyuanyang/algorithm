package com.lingyuanyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumOperationsToMakeASubsequence {

    public static void main(String[] args) {
//        System.out.println(minOperations(new int[]{6, 4, 8, 1, 3, 2}, new int[]{4, 7, 6, 2, 3, 8, 6, 1}));
        System.out.println(minOperations(new int[]{5, 1, 3}, new int[]{9, 4, 2, 3, 4}));
    }

    public static int minOperations(int[] target, int[] arr) {
        int len = target.length;
        List<Integer> index = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (target[i] == arr[j]) {
                    index.add(i, j);
                }
            }
        }
        /*
         * index = {6, 0, 5, 7, 4, 3}    [0, 0, 3]
         * total_nums = 6
         * seq = {1, 1, 2, 3, 2, 2}    [1, 1, 2]
         * count = 6 - 3 = 3
         */
        int[] seq = new int[len];
        seq[0] = 1;
        //tag
        for (int i = 1; i < len; i++) {
            if (index.get(i) == null) {
                for (int j = 0; j < i; j++) {
                    if (index.get(i) > index.get(j)) {
                        seq[i] = seq[j] + 1;
                    } else {
                        seq[i] = Math.max(seq[i], 1);
                    }
                }
            }
            //index[4] =

        }
        System.out.println(Arrays.toString(seq));
        Arrays.sort(seq);
        return len - seq[len - 1];
    }
}
