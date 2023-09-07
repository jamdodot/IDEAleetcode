package com.wut.learn.CodeExam.ShenXinFu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/06/20:22
 * @Description:
 */
public class test4 {
    /**
     * 第一行输入用例数量 接下来每两行一个测试用例
     * 每个用例第一行两个数字n,k 代表n个任务，只需要做内部k个任务
     * 相对顺序不变，删除n-k个任务 剩下k个任务顺序不变
     * 再将k个任务用一刀切开 分别计算左右两部分的时间加和
     * 找出时间最大加和的最小值
     * 第二行n个数字 代表每个任务所需时间
     * 1
     * 6 3
     * 8 1 10 1 1 1
     * 的最小值是2
     */
    public  static void main(String[]args){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            int k=in.nextInt();
            int[] input=new int[n];
            for (int i=0;i<n;i++){
                input[i]=in.nextInt();
            }
            System.out.println(fun(input,k));

        }
    }
    public static int fun(int[] tasks, int k){
       int n=tasks.length;
       int[][]dp=new int[n+1][k+1];
         for(int i=1;i<=n;i++){
              for(int j=1;j<=k;j++){
                dp[i][j]=Integer.MAX_VALUE;
                for(int l=0;l<i;l++){
                     dp[i][j]=Math.min(dp[i][j],Math.max(dp[l][j-1],sum(tasks,l,i-1)));
                }
              }
         }
            return dp[n][k];


    }
    public static int sum(int[] tasks,int start,int end){
        int sum=0;
        for(int i=start;i<=end;i++){
            sum+=tasks[i];
        }
        return sum;
    }

}
