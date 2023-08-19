package com.wut.learn.CodeExam.MeiTuan;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/19/19:22
 * @Description:
 */
public class Autumn2 {
    /**
     * 第一行输入一个整数n
     * 第二行输入n个整数 表示数组a
     * 这n个数使用加号计算
     * 但是其中一个加号可以替换为乘号也可以一个都不替换
     * 求最大和
     */
    public static void main(String[] args){
        /**
         * 第一行输入一个整数n
         * 第二行输入n个整数 表示数组a
         * 这n个数使用加号计算
         * 但是其中一个加号可以替换为乘号也可以一个都不替换
         * 求最大和
         * 样例
         * 6
         * 1 1 4 5 1 4
         * 结果为27 4*5
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n == 1){
            System.out.println(scanner.nextInt());
            return;
        }
        if(n==2){
            long a=scanner.nextInt();
            long b=scanner.nextInt();
            System.out.println(Math.max(a+b,a*b));
            return;
        }
        long[] a = new long[n];
        long  sum = 0L;
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
            sum += a[i];
        }
        long max=sum;
        for(int i=0;i<n-1;i++){
            sum=sum-a[i]-a[i+1];
            long temp=sum+a[i]*a[i+1];
            if(temp>max){
                max=temp;
            }
            sum=sum+a[i]+a[i+1];

        }
        System.out.println(max);

    }
}
