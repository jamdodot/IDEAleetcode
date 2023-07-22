package com.wut.learn.CodeExam;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/04/09/11:19
 * @Description:
 */
public class MultiLine {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       while(sc.hasNext()){
           int n=sc.nextInt();
           int m=sc.nextInt();
           boolean flag=false;
           /**
            * 输出所有水仙花数
            */
           for(int i=n;i<=m;i++){
              int sum=0;
              int temp=i;
              while(temp!=0){
                  int a=temp%10;
                  sum+=a*a*a;
                  temp/=10;
              }
              if (sum==i) {
                  flag=true;
                  System.out.print(i);
                  System.out.print(" ");
              }
           }
           if(!flag){
               System.out.println("no");
           }

       }

    }
}
