package com.wut.learn.CodeExam.ZhaoYinKeJi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/04/15:34
 * @Description:
 */
public class Main1 {
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int [][]input=new int[n][2];
        for (int i=0;i<n;i++){
            input[i][0]=in.nextInt();
            input[i][1]=in.nextInt();
        }
        int count=1;
        Arrays.sort(input,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        for(int i=1;i<n;i++){
            if(input[i][0]<input[i-1][1]){
                input[i][1]=Math.min(input[i][1],input[i-1][1]);
                continue;
            }else{
                count++;
            }
        }
        System.out.println(count);
    }
}
