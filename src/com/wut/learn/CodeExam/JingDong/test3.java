package com.wut.learn.CodeExam.JingDong;

import javax.naming.InsufficientResourcesException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/26/20:19
 * @Description:
 */
public class test3 {
    public static  int[] res;
    public static  void main(String[]args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int score=in.nextInt();
        int[][] nums=new int[n][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                nums[i][j]=in.nextInt();
            }
        }
        res= new int[n];
        int [] res=fun(nums, score);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
           if(res[i]==0) {
               sb.append("F");
           }
           if(res[i]==1){
               sb.append("A");
           }
              if(res[i]==2){
                sb.append("B");
              }
        }
        System.out.println(sb.toString());
    }
    public static int[] fun(int[][] nums,int score){
        int n=nums.length;
        int dp[] =new int [score+1];
        int [][]res= new int [score+1][n];
        for(int i=0;i<n;i++){
            for(int j=score;j>=nums[i][2];j--){
                if(dp[j-nums[i][2]]+nums[i][3]>dp[j]){
                    dp[j]=dp[j-nums[i][2]]+nums[i][3];
                    res[j][i]=2;
                }
                if(j>=nums[i][0]){
                    if(dp[j-nums[i][0]]+nums[i][1]>dp[j]){
                        dp[j]=dp[j-nums[i][0]]+nums[i][1];
                        res[j][i]=1;
                    }
                }
            }
        }
        return res[score];

    }

}
