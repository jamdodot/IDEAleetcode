package com.wut.learn.CodeExam.QiAnXing;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/06/03/19:33
 * @Description:
 */
public class QiAnXIngTest2 {
    public static void main(String[] args){
        /**
         * (0.01,0.99)区间内的一个小数a，求一个真分数n/m，该分数分母m不大于200
         * 他是所有分母不大于200的真分数中最接近a的真分数，如果有两个真分数的值与a接近取分子与分母之和比较小的那个
         */
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
        int n = 0;
        int m = 0;
        float min = Float.MAX_VALUE;
        for(int i=1;i<=200;i++){
            for(int j=1;j<=i;j++){
                float temp = Math.abs((float) j/i-a);
                if(temp<min){
                    min = temp;
                    n = j;
                    m = i;
                }
            }
        }
        int[] res = {n, m};
        System.out.println(n+"/"+m);

    }
}
