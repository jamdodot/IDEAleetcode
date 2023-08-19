package com.wut.learn.CodeExam.XiaoHongShu;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/19/16:24
 * @Description:
 */
public class jingdianjiazhi {
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
     * 使用背包方法，最多选择三个相邻的单位
     * 保证每个景点的浏览时间加上景点之间的交通时间总和不超过k，
     * 并且使得攻略的价值尽可能大，即景点的总价值尽可能大。
     * dp[i][j][k] 表示前i个景点，选择j个相邻的景点，总时间不超过k的最大价值
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//景点个数
        int m = sc.nextInt();//路线条数
        int k = sc.nextInt();//最大时间
        int[] a = new int[n + 1];//攻略价值
        int[] h = new int[n + 1];//浏览时间
        int[][] w = new int[m + 1][3];//交通时间
        for (int i = 1; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i < n; i++) {
            h[i] = sc.nextInt();
        }
        for (int i = 1; i <= m; i++) {
            w[i][0] = sc.nextInt();
            w[i][1] = sc.nextInt();
            w[i][2] = sc.nextInt();
        }
        int maxVal = maxStrategyValue(n, m, a, h, w, k);
        System.out.println(maxVal);
    }

    public static int maxStrategyValue(int n, int m, int[] a, int[] h, int[][] w, int k) {
        // 使用背包方法，最多选择三个相邻的单位
        // 保证每个景点的浏览时间加上景点之间的交通时间总和不超过k，
        // 并且使得攻略的价值尽可能大，即景点的总价值尽可能大。
        // dp[i][j][k] 表示前i个景点，选择j个相邻的景点，总时间不超过k的最大价值
        int[][][] dp = new int[n + 1][4][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 3; j++) {
                for (int l = 0; l <= k; l++) {
                    if (j == 0) {
                        dp[i][j][l] = dp[i - 1][j][l];
                    } else {
                        dp[i][j][l] = dp[i - 1][j][l];
                        if (l >= h[i]) {
                            dp[i][j][l] = Math.max(dp[i][j][l], dp[i - 1][j - 1][l - h[i]] + a[i]);
                        }
                    }
                }
            }
        }

        return dp[n][3][k];
    }

}


