package com.wut.learn.CodeExam.ShenXinFu;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/06/20:04
 * @Description:
 */
public class test3 {
    /**
     * abcde
     * a,bb,acd,ace
     * @param args
     */
    public static void main(String[]args){
        Scanner in =new Scanner(System.in);
        String s=in.nextLine();
        String s2=in.nextLine();
        String [] arr=s2.trim().split(",");
        int res=0;
        for(String s1:arr){
            if(fun(s1,s)){
                res++;
            }
        }
        System.out.println(res);
    }
    public static boolean fun(String word, String s){
        int wordPtr=0;
        int sPtr=0;
        while(wordPtr<word.length()&&sPtr<s.length()){
            if(word.charAt(wordPtr)==s.charAt(sPtr)){
                wordPtr++;
                sPtr++;
            }else{
                sPtr++;
            }
        }
        return wordPtr==word.length();
    }
}
