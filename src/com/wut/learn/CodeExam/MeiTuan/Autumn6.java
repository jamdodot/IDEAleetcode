package com.wut.learn.CodeExam.MeiTuan;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/09/10:15
 * @Description:
 */
public class Autumn6 {
    public  static void main(String[]args){
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int [] output=new int[n];
        int len=m-1;
        int res=0;
        int i=0;
        for( i=1;i<=n;i++){
            int sum=i+(i*(i-1)/2);
            if(sum>len){
                break;
            }else{
                res=Math.max(res,sum);
            }
        }
        i--;
        for(int j=0;j<i;j++){
            output[j]=1+j+(j*(j-1)/2);
        }
        for(int j=i;j<n;i++){
            output[j]+=1;
        }
        for(int c:output){
            System.out.print(c+" ");
        }
    }
}
