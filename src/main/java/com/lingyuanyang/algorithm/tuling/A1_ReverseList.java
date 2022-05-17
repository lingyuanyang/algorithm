package com.lingyuanyang.algorithm.tuling;

public class A1_ReverseList {

    /*
     * 1.链表反转
     *
     * 将单链表的链表顺序反转过来
     * 1 -> 2 -> 3 -> 4 -> 5
     * 5 -> 4 -> 3 -> 2 -> 1
     *
     * 解题思路：Node
     */
    public static void main(String[] args) {
        /*
         * 初始化一个链表 1 -> 2 -> 3 -> 4 -> 5
         */
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
//        ListNode result = iterate(node1);
        ListNode result = recursion(node1);
        System.out.println(result);
    }

    /*
     * 单链表数据结构 -> Node
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
     * 解法一：迭代
     */
    public static ListNode iterate(ListNode head) {
        ListNode prev = null, next;
        // head -> val = 1， next = node2
        ListNode curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /*
     * 解法一：递归
     */
    public static ListNode recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode new_head = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return new_head;
    }


}
