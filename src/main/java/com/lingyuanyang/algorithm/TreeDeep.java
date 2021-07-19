package com.lingyuanyang.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDeep {
    /*
     * 最小深度
     *                 1
     *            2          3
     *        4      5         6
     *                           7
     */
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, node7, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(minDepth2(node1));
    }

    /*
     * 递归
     * 深度优先
     * 时间复杂度O(N)
     * 空间复杂度O(logN)，取决是树的高度
     */
    private static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        /*
         * 此处的min确定当前节点的最小深度，取左右节点的较小值，并返回给父节点，父节点的最小深度会在此基础上叠加
         */
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }

    /*
     * 递归
     * 广度优先
     * 借用队列queue存储
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     */
    private static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        root.deep = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                return node.deep;
            }
            if (node.left != null) {
                node.left.deep = node.deep + 1;
                queue.offer(node.left);
            }
            if (node.right != null) {
                node.right.deep = node.deep + 1;
                queue.offer(node.right);
            }
        }
        return 0;
    }

    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        int deep;

        public TreeNode(int val, TreeNode right, TreeNode left) {
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }
}
