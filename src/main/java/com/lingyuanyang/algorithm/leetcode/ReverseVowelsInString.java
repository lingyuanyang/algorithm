package com.lingyuanyang.algorithm.leetcode;

public class ReverseVowelsInString {
    /*
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     */
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }

    private static String reverseVowels(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int left = 0;
        int right = len - 1;
        while (left < right) {
            while (left < right && isVowel(arr[left])) {
                ++left;
            }
            while (right > 0 && isVowel(arr[right])) {
                --right;
            }
            if (left < right) {
                swap(arr, left, right);
                ++left;
                --right;
            }
        }
        return new String(arr);
    }

    public static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) < 0;
    }

    public static void swap(char[] src, int left, int right) {
        char temp = src[left];
        src[left] = src[right];
        src[right] = temp;
    }
}
