package com.wut.learn.CodeExam.Baidu;

import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/12/19:31
 * @Description:
 */
public class test2 {
    /**
     * 讨厌鬼的组合帖子
     * 4
     * 4 2 1 1
     * 2 1 4 4
     * @param args
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();

        int [] up=new int[n];
        int[]down=new int[n];
        for (int i=0;i<n;i++){
            up[i]=in.nextInt();
        }
        for (int i=0;i<n;i++){
            down[i]=in.nextInt();
        }
        if(n==1) {
            System.out.println(Math.abs(up[0]-down[0]));
            return;
        }
        int res=Integer.MIN_VALUE;
        List<int[]> list=new java.util.ArrayList<>();
        for(int i=0;i<n;i++){
            int[] temp=new int[2];
            temp[0]=up[i];
            temp[1]=down[i];
            list.add(temp);
        }
        //排序条件: o[0]>o[1] 且 o[0]-o[1]越大排在前面
        list.sort((o1, o2) -> {
            if(o1[0]-o1[1]>o2[0]-o2[1]){
                return -1;
            }else if(o1[0]-o1[1]<o2[0]-o2[1]){
                return 1;
            }else {
                return 0;
            }
        });
        int max1=fun(list,n);
        //排序条件: o[0]<o[1] 且 o[1]-o[0]越大排在前面
        list.sort((o1, o2) -> {
            if(o1[1]-o1[0]>o2[1]-o2[0]){
                return -1;
            }else if(o1[1]-o1[0]<o2[1]-o2[0]){
                return 1;
            }else {
                return 0;
            }
        });
        int max2=fun2(list,n);
        System.out.println(Math.max(max1,max2));


    }
    public static int fun(List<int[]> list,int n){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<i;j++){
                sum+=list.get(j)[0]-list.get(j)[1];
                max=Math.max(max,sum);
            }
        }
        return max;
    }
    public static int fun2(List<int[]> list,int n){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<i;j++){
                sum+=list.get(j)[1]-list.get(j)[0];
                max=Math.max(max,sum);
            }
        }
        return max;
    }
}
