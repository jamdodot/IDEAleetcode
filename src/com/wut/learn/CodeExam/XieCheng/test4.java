package com.wut.learn.CodeExam.XieCheng;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/07/20:37
 * @Description:
 */
public class test4 {
        
    public static  void main(String[]args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        System.out.println(count(s));

    }
    public static int count(String s){
        int n=s.length();
        int diffent=0;
        Map<Integer, Integer> counts_1=new HashMap<>();
        counts_1.put(0,1);
        int res=0;
        for(int i=0;i<n;i++){
           diffent+=(s.charAt(i)=='0'?1:-1);
           res+=counts_1.getOrDefault(diffent-1,0);
           counts_1.put(diffent,counts_1.getOrDefault(diffent,0)+1);
        }
        return res;

    }
}
