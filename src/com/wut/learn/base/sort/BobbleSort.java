package com.wut.learn.base.sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/25/18:48
 * @Description:
 */
public class BobbleSort {
    /**
     * 冒泡排序
     * @param args
     */
    public static void main(String[] args){
        int[] arr={1,3,2,5,4,7,6,9,8};
        sort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    public static void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                int temp=0;
                if(arr[j]>arr[j+1]){
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
}
