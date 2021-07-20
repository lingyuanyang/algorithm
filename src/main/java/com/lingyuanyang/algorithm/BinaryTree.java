package com.lingyuanyang.algorithm;

import java.util.*;

public class BinaryTree {
    /*
     * 二叉树遍历
     *       1
     *     2   3
     *   4  5
     *     6 7
     */
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, node6, node7);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
//        //前序遍历(根左右) - 递归
//        preOrder(node1);
//        //中序遍历(左根右) - 递归
//        midOrder(node1);
//        //后序遍历(左右根) - 递归
//        postOrder(node1);
//        //层序遍历 - 递归
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        levelOrder(node1, 1, list);
//        System.out.println(Arrays.toString(list.toArray()));
//        for (Integer num : list) {
//            if (num != null) {
//                System.out.println(num);
//            }
//        }
//        //前序遍历(根左右) - 迭代
//        preOrder1(node1);
//        //中序遍历(根左右) - 迭代
//        midOrder1(node1);
//        //后序遍历(左右根) - 迭代
//        postOrder1(node1);
//        //层序遍历 - 迭代
//        levelOrder2(node1);
//        //前序遍历 - morris
//        morrisPre(node1);
//        //中序遍历 - morris
//        morrisMid(node1);
        //后序遍历 - morris
        morrisPost(node1);
    }

    /*
     * 前序遍历(根左右) - 递归
     */
    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);//第一次压入栈顶即打印
        preOrder(root.left);
        preOrder(root.right);
    }

    /*
     * 中序遍历(左根右) - 递归
     */
    private static void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);
        System.out.println(root.val);//第二次压入栈顶即打印
        midOrder(root.right);
    }

    /*
     * 后序遍历(左右根) - 递归
     */
    private static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);//第三次压入栈顶即打印
    }

    /*
     * 层序遍历 - 递归
     */
    private static void levelOrder(TreeNode root, int i, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        int len = list.size();
        if (len <= i) {
            for (int j = 0; j <= i - len; j++) {
                list.add(len + j, null);
            }
        }
        list.set(i, root.val);
        levelOrder(root.left, i * 2, list);
        levelOrder(root.right, i * 2 + 1, list);
    }

    /*
     * 前序遍历(根左右) - 迭代
     */
    private static void preOrder1(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                if (root != null) {
                    System.out.println(root.val);
                    stack.push(root.right);
                    stack.push(root.left);
                }
            }
        }
    }

    /*
     * 中序遍历(根左右) - 迭代
     */
    private static void midOrder1(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.println(root.val);
                    root = root.right;
                }
            }
        }
    }

    /*
     * 后序遍历(左右根) - 迭代
     */
    private static void postOrder1(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev = null;
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || root.right == prev) {
                    System.out.println(root.val);
                    prev = root;
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }
        }
    }

    /*
     * 层序遍历 - 迭代
     */
    private static void levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.println(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    /*
     * 前序遍历 - morris
     */
    private static void morrisPre(TreeNode curr) {
        TreeNode mostRight = null;
        while (curr != null) {
            mostRight = curr.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != curr) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = curr;
                    System.out.println(curr.val);
                    curr = curr.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                System.out.println(curr.val);
            }
            curr = curr.right;
        }
    }

    /*
     * 中序遍历 - morris
     */
    private static void morrisMid(TreeNode curr) {
        TreeNode mostRight = null;
        while (curr != null) {
            mostRight = curr.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != curr) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = curr;
                    curr = curr.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.println(curr.val);
            curr = curr.right;
        }
    }

    /*
     * 后序遍历 - morris
     */
    private static void morrisPost(TreeNode curr) {
        TreeNode mostRight = null;
        TreeNode root = curr;
        while (curr != null) {
            mostRight = curr.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != curr) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {//建立线索指针
                    mostRight.right = curr;
                    curr = curr.left;
                    continue;
                } else {//删除线索指针
                    mostRight.right = null;
                    printNode(curr.left);
                }
            }
            curr = curr.right;
        }
        printNode(root);
    }

    private static void printNode(TreeNode head) {
        TreeNode tail = reverse(head);
        while (tail != null) {
            System.out.println(tail.val);
            tail = tail.right;
        }
        reverse(tail);
    }

    private static TreeNode reverse(TreeNode head) {
        TreeNode prev = null, next;
        while (head != null) {
            next = head.right;
            head.right = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        int deep;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }
}
