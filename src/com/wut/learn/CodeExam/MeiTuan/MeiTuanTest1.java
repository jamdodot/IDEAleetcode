package com.wut.learn.CodeExam.MeiTuan;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/04/15/9:55
 * @Description:
 */
public class MeiTuanTest1 {
    static int[] [] dp;
    public static void main(String[] args) {
        /**
         * 现在有两个字符串S和T，你需要对S进行若干次操作，
         * 使得S是T的一个前缀（空串也是一个前缀）。
         * 每次操作可以修改S的一个字符，或者删除一个S末尾的字符。
         */
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int n_=num;
        while(n_>0){
            String s=sc.next();
            String t=sc.next();
            int res=0;
            int s_len=s.length(),t_len=t.length();
            int idx1=0,idx2=0;
            while(idx1<s_len&&idx2<t_len){
                if(s.charAt(idx1)==t.charAt(idx2)){
                    idx1++;
                    idx2++;
                }else{
                    idx1++;
                    idx2++;
                    res++;
                }
            }
            res = idx1 < s_len ? (res +s_len - idx1) : res + 0;
            System.out.println(res);
        }
    }


}
