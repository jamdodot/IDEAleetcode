package com.wut.learn.CodeExam;

import java.util.Scanner;
import java.util.Arrays;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/09/16:33
 * @Description:
 */
public class wanmeishijie {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] number =(n+"").toCharArray();
        int i,j;
        for(i=number.length-1;i>=1;i--){
            if(number[i]<number[i+1]) break;
        }
        if(i<0){
            System.out.println(-1);
            return ;
        }
        //找到第一个比number[i]大的数
        for(j=number.length-1;j>i;j--){
             if(number[j]>number[i]) break;
        }
        //交换
        char temp=number[i];
        number[i]=number[j];
        number[j]=temp;
         //反转
        Arrays.sort(number,i+1,number.length);
        long val=Long.parseLong(new String(number));
        System.out.println(val<=Integer.MAX_VALUE?(int)val:-1);



//        char[] digits = String.valueOf(n).toCharArray();
//        // 从右向左找到第一个相邻的数字，前一个数字小于后一个数字的位置
//        int i = digits.length - 2;
//        while (i >= 0 && digits[i] >= digits[i + 1]) {
//            i--;
//        }
//        // 如果找不到这样的位置，说明已经是最大排列，无法找到更大的数字
//        if (i < 0) {
//            System.out.println(-1);
//        }
//        // 从右向左找到第一个大于digits[i]的位置
//        int j = digits.length - 1;
//        while (j >= 0 && digits[j] <= digits[i]) {
//            j--;
//        }
//        // 交换位置i和j上的数字
//        swap(digits, i, j);
//        // 反转i位置之后的数字
//        reverse(digits, i + 1);
//        try {
//            System.out.println(Integer.parseInt(new String(digits)));
//        } catch (NumberFormatException e) {
//            System.out.println(-1);
//        }
//    }
//    private static void swap(char[] arr, int i, int j) {
//        char temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    private static void reverse(char[] arr, int start) {
//        int i = start;
//        int j = arr.length - 1;
//        while (i < j) {
//            swap(arr, i, j);
//            i++;
//            j--;
//        }
//    }







//        //转换为StringBuilder
//        StringBuilder input=new StringBuilder();
//        while(n>0){
//            input.append(n%10);
//            n/=10;
//        }
//        //顺序翻转
//        input.reverse();
//        int min=Integer.MAX_VALUE;
//        int minIdx=0;
//        int maxIdx=0;
//        int max=Integer.MAX_VALUE;
//        for(int i=input.length()-1;i>0;i--){
//            if(Integer.parseInt(input.charAt(i)+"")<min){
//                min=Integer.parseInt(input.charAt(i)+"");
//                minIdx=i;
//            }
//
//        }
//        for(int i=input.length()-1;i>0;i--){
//            if(Integer.parseInt(input.charAt(i)+"")>min&&Integer.parseInt(input.charAt(i)+"")<max){
//                max=Integer.parseInt(input.charAt(i)+"");
//                maxIdx=i;
//            }
//        }
//        if(maxIdx==minIdx|| maxIdx<minIdx){
//            System.out.println(-1);
//            return;
//        }
//        char temp=input.charAt(maxIdx);;
//        input.setCharAt(maxIdx,input.charAt(minIdx));
//        input.setCharAt(minIdx,temp);
//        System.out.println(input.toString());


    }
}
