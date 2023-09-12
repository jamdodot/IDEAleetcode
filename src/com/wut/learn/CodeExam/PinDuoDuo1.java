package com.wut.learn.CodeExam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/10/15:59
 * @Description:
 */
public class PinDuoDuo1 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[] nums=new int [n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        Arrays.sort (nums) ;
        int res = 0;
        int left = n-2;
        int right = n-1;
        boolean [] used =new boolean[n];
        while(left>=0&& right>0) {
            if (nums[right]-nums[left]>=m){
                used[left]=true;
                used[right]=true;
                res++;
                left--;
                right--;
                while (right>0&&used[right]){
                    right--;
                }
                while (left>0&&used[left]||left>=right){
                    left--;
                }
            } else{
                left--;
            }
        }
        System.out.println(res);
    }
}
