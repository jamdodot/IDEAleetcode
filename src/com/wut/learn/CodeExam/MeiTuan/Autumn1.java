package com.wut.learn.CodeExam.MeiTuan;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/19/17:48
 * @Description:
 */
public class Autumn1 {
    /**
     * 第一行输入一个整数q
     * 接下来q行每行两个整数m x
     * 假设订单从1开始 没生成一个订单 编号加1
     * 当订单上限为m时 第x个订单编号是多少
     * 订单从1开始
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int[] m = new int[q];
        int[] x = new int[q];
        for(int i = 0; i < q; i++){
            m[i] = sc.nextInt();
            x[i] = sc.nextInt();
        }
        for(int i = 0; i < q; i++){
            System.out.println(getOrderNum(m[i], x[i]));
        }


    }
    //订单从1开始
    public static int getOrderNum(int m, int x){
        int num = 0;
        if(x <= m){
            return x;
        }else{
            num = x % m;
            if(num == 0){
                num = m;
            }
        }
        return num;
    }



}
