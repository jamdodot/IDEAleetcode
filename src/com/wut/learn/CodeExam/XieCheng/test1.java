package com.wut.learn.CodeExam.XieCheng;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/07/19:03
 * @Description:
 */
public class test1 {

    public static void main(String[]args){
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(count(n));
    }
    private static boolean check(int num){
        if(num<=1)return false;
        if(num<=3)return true;
        if(num%2==0||num%3==0)return false;
        int i=5;
        while(i*i<=num){
            if(num%i==0||num%(i+2)==0)return false;
            i+=6;
        }
        return true;
    }
    public static boolean isValid(int[] array){
        for(int i=1;i<array.length;i++){
            if(check(array[i-1]+array[i])){return false;}

        }
        return true;
    }
    public static void generate(int num, int[] current, boolean[] used, int position, List<int[]> allResult){
        if(position==num){
            if(isValid(current)){
                allResult.add(current.clone());
            }
            return;
        }
        for(int i=1;i<=num;i++){
            if(!used[i-1]){
                used[i-1]=true;
                current[position]=i;
                generate(num,current,used,position+1,allResult);
                used[i-1]=false;
            }
        }

    }

    public static int count(int num){
        List<int[]> result=new ArrayList<>();
        generate(num,new int[num],new boolean[num],0,result);
        return result.size();
    }


}
