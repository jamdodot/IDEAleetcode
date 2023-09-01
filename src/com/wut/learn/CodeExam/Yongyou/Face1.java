package com.wut.learn.CodeExam.Yongyou;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/01/21:20
 * @Description:
 */
public class Face1 {
    public  static void main(String[]args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int x=in.nextInt();
        int []input=new int[n];
        for(int i=0;i<n;i++){
            input[i]=in.nextInt();
        }
        int left=0;
        int right=n-1;
        while(left<right){
            if(input[left]+input[right]==x){
                System.out.println("TRUE");
                return;
            }else if (input[left]+input[right]>x) {
                right--;
            }else{
                left++;
            }
        }
        System.out.println("FALSE");
    }
}
