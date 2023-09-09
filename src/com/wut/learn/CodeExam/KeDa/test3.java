package com.wut.learn.CodeExam.KeDa;

import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/09/14:53
 * @Description:
 */
public class test3 {
    /**
     * 从input数组中选一个最长子序列
     * 满足子序列内任何一段的平均数都大于average
     * 使用动态规划
     * @param args
     */
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int average = in.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
        }
        long cnt = 0;
        boolean vis[] = new boolean[n];
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (input[i] >= average) {
                cnt++;
                vis[i] = true;
                ls.add(i);
            }
        }
        if (ls.size() < 2) {
            System.out.println(ls.size());
            return;
        }
        for (int i = 1; i < ls.size(); i++) {
            int l = ls.get(i - 1);
            int r = ls.get(i);
            int pos = l + 1;
            while (pos < r) {
                if (input[pos] + input[l] + input[r] >= average * 3 && help(pos, input, vis, average)) {
                    vis[pos] = true;
                    cnt++;
                    break;
                }
                pos++;
            }
        }
        System.out.println(cnt);
    }
    public static boolean help(int pos,int[] input,boolean[] vis,int m){
        int n=input.length;
        int res=input[pos];
        int sum=m;
        pos=pos-1;
        while(pos>=0){
            if(vis[pos]){
                res+=input[pos];
                sum+=m;
                if(res<sum) return false;

            }
            pos--;
        }
        return true;

    }

//        if(n==1){
//            System.out.println(input[0]>=average?1:0);
//            return;
//        }
//        int res=0;
//        int [][]dp=new int[n][2];
//        for(int i=0;i<n;i++){
//            if(input[i]>=average){
//                dp[i][0]=1;
//                dp[i][1]=average+input[i];
//            }else{
//                dp[i][0]=0;
//                dp[i][1]=average+input[i];
//            }
//        }
//        for(int i=1;i<n;i++){
//            for(int j=0;j<i;j++){
//                if(input[i]+input[j]>=2*average&&input[i]+dp[j][1]>=3*average){
//                    if(dp[j][0]+1>dp[i][0]){
//                        dp[i][0]=dp[j][0]+1;
//                        dp[i][1]=input[j]+input[i];
//                    }
//                    res = Math.max(res, dp[i][0]);
//                }
//
//            }
//        }
//        System.out.println(res);



}
