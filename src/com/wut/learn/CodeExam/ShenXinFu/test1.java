package com.wut.learn.CodeExam.ShenXinFu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/06/19:34
 * @Description:
 */
public class test1 {
    //求所有字符组成的全子集
    public static void main(String[]args){
        Scanner in =new Scanner(System.in);
        String s=in.nextLine();
        String[] arr=s.trim().split("");
        //转换为数组并去重
       int n=s.length();
        Set<String> set=new HashSet<>();
        for(String s1: arr){
            set.add(s1);
        }
       System.out.println((int)Math.pow(2, set.size())-1);

    }
}
