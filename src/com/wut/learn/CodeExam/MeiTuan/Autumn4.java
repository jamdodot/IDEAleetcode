package com.wut.learn.CodeExam.MeiTuan;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/19/20:07
 * @Description:
 */
public class Autumn4 {
    static long res=0;
    public static void main(String[] args){
        System.out.println(fun(args));
    }
    public static long  fun(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
        dfs(a,sum,0);
        return res%1000000007;
    }
    public static void dfs(int[]a ,int sum,int index){
        if(index==(a.length-1)&&sum!=a[a.length-1]){
            res++;
            return ;
        }
        if(index==(a.length-1)){
            return ;
        }
        for(int i=1;i<sum;i++){
            if(a[index]!=i){
                sum-=i;
                dfs(a,sum,index+1);
                sum+=i;
            }
        }

    }
}
