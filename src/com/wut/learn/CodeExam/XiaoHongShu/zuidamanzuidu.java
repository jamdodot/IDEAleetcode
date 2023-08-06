package com.wut.learn.CodeExam.XiaoHongShu;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/06/19:28
 * @Description:
 */
public class zuidamanzuidu {
    /**
     * 小红很喜欢前往小红书分享她的日常生活。已知她生活中有n个事件，分享第i
     * 个事件需要她花费ti的时间和hi的精力来编辑文章，并能获得ai的快乐值。
     * 小红想知道，在总花费时间不超过T且总花费精力不超过H的前提下，小红最
     * 多可以获得多少快乐值?
     */
    public static void main(String[] args){
        int n = 3;
        int T = 5;
        int H = 4;
        int[] t = new int[]{1,2,4};
        int[] h = new int[]{2,1,1};
        int[] a = new int[]{2,3,5};
        int[][] dp = new int[T+1][H+1];
        for(int i = 0; i < n; i++){
            for(int j = T; j >= t[i]; j--){
                for(int k = H; k >= h[i]; k--){
                    dp[j][k] = Math.max(dp[j][k], dp[j-t[i]][k-h[i]] + a[i]);
                }
            }
        }
        System.out.println(dp[T][H]);
    }


}
