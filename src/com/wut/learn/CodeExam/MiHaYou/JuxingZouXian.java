package com.wut.learn.CodeExam.MiHaYou;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/13/20:30
 * @Description:
 */
public class JuxingZouXian {
    /**
     * 已知1个n*m的矩阵，左下角坐标是(1, 1),右上角坐标是(n, m)。1号每次可以走到相邻的
     * 坐标即当|x1-x2|+|y1-y2|= 1时，1号可以从
     * (x1, Y1 )走到(x2, Y2)。
     * 另外，矩阵有一个特殊的特性，其左边界和右边界是相
     * 邻的，上边界和下边界也是相邻的。也就是说，(x, 1)和
     * (x, m)相邻，(1, y)和(n, y)也是相邻的。
     * 现在按顺序给定了1号、2号和3号的坐标，请你判
     * 断1号最少需要走几步。
     */
    public static void main(String[] args){
        int n = 3;
        int m = 3;

        int[][] matrix = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int[] coord1 = {1, 1};
        int[] coord2 = {3, 1};
        int[] coord3 = {1, 3};

        int minSteps = findMinimumSteps(matrix, coord1, coord2, coord3);
        System.out.println("Minimum steps required for 1号: " + minSteps);
    }

    public static int findMinimumSteps(int[][] matrix, int[] coord1, int[] coord2, int[] coord3) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Initialize a 2D array to store the minimum steps required to reach each coordinate
        int[][] steps = new int[n + 2][m + 2];

        // Set all steps to a large value initially
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(steps[i], Integer.MAX_VALUE);
        }

        // Queue to perform breadth-first search
        Queue<int[]> queue = new LinkedList<>();

        // Start from coord1 and set its steps to 0
        steps[coord1[0]][coord1[1]] = 0;
        queue.offer(coord1);

        // Perform breadth-first search
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int currentSteps = steps[x][y];

            // Check all adjacent coordinates
            int[][] adjCoords = {
                    {x - 1, y},
                    {x + 1, y},
                    {x, y - 1},
                    {x, y + 1}
            };

            for (int[] adjCoord : adjCoords) {
                int adjX = adjCoord[0];
                int adjY = adjCoord[1];

                // If the adjacent coordinate is within the matrix boundaries and can be reached in fewer steps,
                // update its steps value and add it to the queue for further exploration
                if (adjX >= 1 && adjX <= n && adjY >= 1 && adjY <= m &&
                        steps[adjX][adjY] > currentSteps + 1) {
                    steps[adjX][adjY] = currentSteps + 1;
                    queue.offer(adjCoord);
                }
            }
        }

        // Return the minimum steps required for coord2
        return steps[coord2[0]][coord2[1]];
    }

}
