package com.lingyuanyang.algorithm.tuling;

import java.util.HashSet;
import java.util.Set;

public class A10_LinkCycle {
    /*
     * 10.环形链表
     * 给定一个链表，判断链表中是否有环
     */
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        //1 -> 2 -> 3-> 4 -> 5 -> 3
        node5.next = node3;
        System.out.println(hasCycle(node1));
        System.out.println(twoPointer(node1));
    }

    /*
     * ListNode 数据结构
     */
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
     * 解法一：循环遍历
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head.next != null) {
            //set.add()如果元素已经存在则返回false，否则返回true
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /*
     * 解法二：双指针、快慢指针(龟兔赛跑)
     * 空间复杂度 O(1)
     */
    public static boolean twoPointer(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != quick) {
            if (quick == null || quick.next == null) {
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }
}
