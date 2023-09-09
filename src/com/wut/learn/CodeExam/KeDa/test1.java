package com.wut.learn.CodeExam.KeDa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/09/13:53
 * @Description:
 */
public class test1 {
    public static void main(String[]args){
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int a=in.nextInt();
        int b=in.nextInt();
        int [] input =new int[n];
        for(int i=0;i<n;i++){
            input[i]=in.nextInt();
        }
        Map<Integer,Integer> record=new HashMap<>();
        for(int i=0;i<n;i++){
            record.put(input[i],record.getOrDefault(input[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:record.entrySet()){
            if(entry.getValue()==b){
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}
