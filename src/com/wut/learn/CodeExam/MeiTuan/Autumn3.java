package com.wut.learn.CodeExam.MeiTuan;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/19/19:38
 * @Description:
 */
public class Autumn3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char str[]=scanner.next().toCharArray();
        long res=0;
        for(int i=0;i<str.length;i++){
            for(int j=i+1;j<str.length;j++){
                res+=solution(str,i,j);
            }
        }
        System.out.println(res);

    }
    public static long solution(char[]ch, int l,int r){
        char cur[]={'0','1'};
        long res0=0;
        int pos=0;
        for(int i=l;i<=r;i++){
            if(ch[i]!=cur[(pos++)%2]){
                res0++;
            }
        }
        long res1=0;
        pos=1;
        for(int i=l;i<=r;i++){
            if(ch[i]!=cur[(pos++)%2]){
                res1++;
            }
        }
        return Math.min(res0,res1);

    }
//    public static int getTotalWeight(String s){
//        int totalWeight = 0;
//        for(int i = 0; i < s.length(); i++){
//           for(int j=i+1;j<=s.length();j++){
//               totalWeight+=getSubStringWeight(s.substring(i,j));
//           }
//        }
//        return totalWeight;
//    }
//    public static int getSubStringWeight(String s){
//        //对字符串取反0变1 1变0  计算使得所有相邻字符串不相同的取反次数
//        int sum=0;
//        StringBuilder sb=new StringBuilder(s);
//        for(int i=0;i<sb.length()-1;i++){
//            if(sb.charAt(i)==sb.charAt(i+1)){
//                sb.setCharAt(i,sb.charAt(i)=='0'?'1':'0');
//                sum++;
//                i+=1;
//            }
//        }
//        return sum;
//    }
}
