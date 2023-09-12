package com.wut.learn.CodeExam.Baidu;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/12/19:00
 * @Description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int count=in.nextInt();
        while (count-->0){
            int n=in.nextInt();
            int m=in.nextInt();
            if(n%2==0&&m%2==0){
                System.out.println("No");
                continue;
            }
            if(n%2!=0&&m%2!=0){
                System.out.println("No");
                continue;
            }
            System.out.println("Yes");
        }


    }
}
