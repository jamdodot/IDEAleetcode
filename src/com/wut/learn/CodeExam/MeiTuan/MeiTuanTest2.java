package com.wut.learn.CodeExam.MeiTuan;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/04/15/9:55
 * @Description:
 */
public class MeiTuanTest2 {
    public static void main(String[] args) {
        /**
         * 小美从商店买了两种糖果，分别买了a个和b个，要分给班上n个小朋友。为了不浪费，
         * 每块糖果都得恰好分到一个小朋友。另外，两种糖果一起吃的话味道其实并不好，
         * 所以每一个小朋友都只能得到其中一种糖果。
         * 小美希望分得最少糖果的那个小朋友能得到尽量多的糖果。小美的任务是求得这个数量是多少。
         */
        /**
         * 第一行一个正整数T，表示有T组数据。
         *
         * 对于每一组数据，输入一行n,a,b，中间用空格隔开。
         *
         * 1≤a,b≤10000,   2≤n≤a+b,  1≤T≤100
         */
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int n_=num;
        while(n_>0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int res = 1;
            int res2=1;
            if(a>b) {
                int temp = a;
                a = b;
                b = temp;
            }
            int a1=0;
            //向上取整
            if((a*n)%(a+b)!=0){
                a1=(a*n)/(a+b)+1;
            }else{
                a1=(a*n)/(a+b);
            }
            res=a/a1;
            res2=b/(n-a1);
            System.out.println(Math.min(res,res2));
            n_--;
        }
    }
}
