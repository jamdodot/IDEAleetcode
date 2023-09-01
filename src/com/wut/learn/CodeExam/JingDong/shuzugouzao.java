package com.wut.learn.CodeExam.JingDong;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/26/19:27
 * @Description:
 */
public class shuzugouzao {
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] input=new int[n];
        for(int i=0;i<n;i++){
            input[i]=in.nextInt();
        }
        //下表从1开始满足(ai+bi)%i==0
        int[] result=new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int temp =(input[i]/(i+1)+1)*(i+1)-input[i];
            if(map.containsKey(temp)) {
                while(map.containsKey(temp)){
                    temp+=i+1;
                }
                map.put(temp, i);
            }
            result[i]=temp;
            map.put(result[i],i);

        }

        for(int i=0;i<n;i++){
            System.out.print(result[i]+" ");
        }

    }
}
