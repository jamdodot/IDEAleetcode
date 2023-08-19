package com.wut.learn.CodeExam.MeiTuan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/19/20:24
 * @Description:
 */
public class Autumn5 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }
        System.out.println(minOperate(nums));


    }
    public static long minOperate(int[] nums){
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int zN=sum/n;
        if(sum%n==0){
            int op=0;
            for (int i=0;i<n;i++){
                if(nums[i]>zN){
                    op+=nums[i]-zN;
                }
            }
            return op;
        }
        Arrays.sort(nums);
        return Math.min(opTimes(nums,1,n-1),opTimes(nums,0,n-2));
    }

    public static long opTimes(int[] nums,int l,int r){
        long sum=0;
        long len=r-l+1;
        for(int i=l;i<=r;i++){
            sum+=nums[i];
        }
        long zNum=sum/len;
        return Math.min(minOp(nums,l,r,zNum),minOp(nums,l,r,zNum+1));


    }
    public static long minOp(int[] nums,int l,int r,long zNum){
        long big=0;
        long small=0;
        for(int i=l;i<=r;i++){
            int num=nums[i];
            if(num>zNum) big+=num-zNum;
            if(num<zNum) small+=zNum-num;
        }
        return Math.min(big,small);
    }

}
