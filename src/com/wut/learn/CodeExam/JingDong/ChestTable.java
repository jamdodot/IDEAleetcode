package com.wut.learn.CodeExam.JingDong;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/19/10:26
 * @Description:
 */
public class ChestTable {
    /**
     * 一个n行m列的棋盘，有一些格子是障碍物
     * 不能通过，小红控制一个皇后在从左上角出
     * 发，可次移动她可以控制皇后进行以下三种方式中的一种:
     * 1向右移动若干个格子，
     * 2向下移动若干个格子，
     * 3向右下移动若干个格子。
     * 用数学语言描述，当前的坐标在(x，y)时，每
     * 次移动可以到(x+k，y)或(x,y+k)或
     * (x+k,y+k)，其中人为任意正整数。移动的前提是，路径上没有障碍物。
     * 小红想知道，皇后从左上角移动到右下角，最少要移动多少步?
     * 第行输入两个正整数n和m,代表行数和列。
     * 接下来的n行，每行输入一个长度m的字符串，
     * 用来表示棋盘。
     * 其中.代表可以通过的位置，*代表障碍物。
     */
    static boolean  flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[][] matrix = new String[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.substring(j, j + 1);
            }
        }
        boolean[][] visited = new boolean[n][m];
        int minSteps = dfs(matrix, visited, 0, 0, n, m);
        System.out.println(minSteps == Integer.MAX_VALUE ? -1 : minSteps);
    }
    private static int dfs(String[][] grid, boolean[][] visited, int x, int y, int n, int m) {
        // 到达右下角，返回0步
        if (x == n - 1 && y == m - 1) {
            return 0;
        }
        visited[x][y] = true;

        int minSteps = Integer.MAX_VALUE;
        // 向右移动
        for (int i = 1; i <= m; i++) {
            if (y + i < m && !visited[x][y + i] && !grid[x][y + i].equals("*")) {
                int steps = dfs(grid, visited, x, y + i, n, m);
                if (steps != -1) {
                    minSteps = Math.min(minSteps, steps + 1);
                }
            }else{
                break;
            }
        }
        // 向下移动
        for (int i = 1; i <= n; i++) {
            if (x + i < n && !visited[x + i][y] && !grid[x+i][y].equals("*")) {
                int steps = dfs(grid, visited, x + i, y, n, m);
                if (steps != -1) {
                    minSteps = Math.min(minSteps, steps + 1);
                }
            }else{
                break;
            }
        }
        // 向右下移动
        for (int i = 1; i <= Math.max(n, m); i++) {
            if (x + i < n && y + i < m && !visited[x + i][y + i] && !grid[x+i][y+i].equals("*")) {
                int steps = dfs(grid, visited, x + i, y + i, n, m);
                if (steps != -1) {
                    minSteps = Math.min(minSteps, steps + 1);
                }
            }else{
                break;
            }
        }
        visited[x][y] = false;


        // 如果无法到达右下角，则返回-1
        if (minSteps == Integer.MAX_VALUE) {
            return -1;
        }

        return minSteps;
    }
    /**
     * 3 3
     * ...
     * .**
     * .*.
     * 3 4
     * ....
     * **.*
     * ....
     * 3 3
     * ...
     * .**
     * ...
     * 3 3
     * ...
     * ..*
     * ...
     */
//        backtrace(new int[]{0,0},matrix);
//        System.out.println(flag);
//
//    }
//    public static void backtrace(int[] position,String [][] matrix){
//        if(position[0]>=matrix.length||position[1]>=matrix[0].length){
//            return;
//        }
//        if(position[0]==matrix.length-1&&position[1]==matrix[0].length-1){
//            flag=true;
//            return;
//        }
//        if(isValid(matrix,new int[]{position[0]+1,position[1]})){
//            position[0]++;
//            backtrace(position,matrix);
//            position[0]--;
//        }
//        if (isValid(matrix,new int[]{position[0],position[1]+1})){
//            position[1]++;
//            backtrace(position,matrix);
//            position[1]--;
//        }
//        if (isValid(matrix,new int[]{position[0]+1,position[1]+1})){
//            position[0]++;
//            position[1]++;
//            backtrace(position,matrix);
//            position[0]--;
//            position[1]--;
//        }
//
//    }
//      static  boolean isValid(String[][] matrix,int[] position){
//        if(position[0]<0||position[0]>=matrix.length||position[1]<0||position[1]>=matrix[0].length){
//            return false;
//        }
//        if(matrix[position[0]][position[1]]=="*"){
//            return false;
//        }
//        return true;
//    }



}
