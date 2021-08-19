package com.lingyuanyang.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class GroupMerge {
    public static void main(String[] args) {
        System.out.println(getProvinceDfs(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(getProvinceDfs(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        System.out.println(getProvinceBfs(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(getProvinceBfs(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }

    /*
     * 深度优先
     */
    private static int getProvinceDfs(int[][] cityConnected) {
        int citys = cityConnected.length;
        boolean[] visited = new boolean[citys]; //{false, false, false}
        int provinces = 0;
        for (int i = 0; i < citys; i++) {
            if (!visited[i]) {
                /*
                 * Depth-First-Search -> dfs
                 */
                dfs(i, citys, visited, cityConnected);
                provinces++;
            }
        }
        return provinces;
    }

    private static void dfs(int i, int citys, boolean[] visited, int[][] cityConnected) {
        for (int j = 0; j < citys; j++) {
            if (cityConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j, citys, visited, cityConnected);
            }
        }
    }

    /*
     * 广度优先
     * Breadth First Search -> bfs
     */
    private static int getProvinceBfs(int[][] cityConnected) {
        int citys = cityConnected.length;
        boolean[] visited = new boolean[citys]; //{false, false, false}
        int provinces = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < citys; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int k = queue.poll();
                    visited[k] = true;
                    for (int j = 0; j < citys; j++) {
                        if (cityConnected[i][j] == 1 && !visited[j]) {
                            queue.offer(j);
                        }
                    }
                }
                provinces++;
            }
        }
        return provinces;
    }
}
