package com.wut.learn.CodeExam.XieCheng;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/07/19:18
 * @Description:
 */
public class test2 {
    /**
     * 第一行输入两个整数n m 表示矩阵行和列
     * 接下来n行输入n行字符串
     * 以y, o, u为顶点组成直角三角形且直角边保持水平和垂直
     * 求满足这样条件的直角三角形有多少个
     * 2 3
     * you
     * our
     * 输出为 3
     * @param args
     */
    public static void main(String[]args){
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        String[] arr=new String[n];
        for(int i=0;i<n;i++){
            arr[i]=in.next();
        }




    }
}
