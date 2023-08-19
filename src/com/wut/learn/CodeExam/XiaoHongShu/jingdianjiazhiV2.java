package com.wut.learn.CodeExam.XiaoHongShu;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/19/16:24
 * @Description:
 */

    /**
     * 某市有n个景点，有m条路线，每个景点的攻略价值是a,要花费h时间浏览，不同最点之间的交通时间为w.小红最
     * 多会选择3个相领的景点。她需要保证每个景点的浏览时间加上景点之间的交通时间总和不超过k,
     * 并且使得攻略的价值尽可能大，即景点的总价值尽可能大。
     * 求攻略的最大价值，
     * 第一行输入三个整数n,m，含义如题目描述所示。
     * 第二行输入n个整数表示数组a。
     * 第三行输入n个整数表示数组h。
     * 接下来m行，每行输入三个整数u,v(1≤u,v≤n),w(1≤w<=109) 表示景点u,v之间的
     * 交通时间为w。
     * 动态规划解决
     */
import java.util.ArrayList;
import java.util.List;

public class jingdianjiazhiV2 {

    static class Pair {
        int vertex;
        int weight;
        public Pair(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }
    }

    public static int getMaxValue(int n, int m, int k, int[] values, int[] hours, int[][] routes) {
        List<Pair>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = routes[i][0] - 1;
            int v = routes[i][1] - 1;
            int w = routes[i][2];

            adjList[u].add(new Pair(v, w));
            adjList[v].add(new Pair(u, w));
        }

        int maxVal = 0;

        for (int i = 0; i < n; i++) {
            List<Pair> neighbors = adjList[i];
            for (Pair next : neighbors) {
                int time = hours[i] + hours[next.vertex] + next.weight;
                int value = values[i] + values[next.vertex];
                if (time <= k) maxVal = Math.max(maxVal, value);
                for (Pair nextNext : adjList[next.vertex]) {
                    if (nextNext.vertex == i) continue;
                    int timeWith3 = time + hours[nextNext.vertex] + nextNext.weight;
                    int valueWith3 = value + values[nextNext.vertex];
                    if (timeWith3 <= k) maxVal = Math.max(maxVal, valueWith3);
                }
            }
        }

        return maxVal;
    }

    public static void main(String[] args) {
        int n = 4, m = 4, k = 8;
        int[] values = {4, 3, 2, 1};
        int[] hours = {1, 2, 3, 4};
        int[][] routes = {{1, 2, 1}, {2, 3, 1}, {2, 4, 1}, {3, 4, 1}};

        System.out.println(getMaxValue(n, m, k, values, hours, routes));  // Expected output: 9
    }
}

