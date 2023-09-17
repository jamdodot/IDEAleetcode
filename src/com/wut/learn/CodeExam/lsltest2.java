package com.wut.learn.CodeExam;

import com.wut.learn.CodeExam.ELeMa.test1;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/16/19:57
 * @Description:
 */
public class lsltest2 {
    public static void main(String[] args) {
       int [] nums=new int [] {1,2,3,20,28};
        List<Integer> list = new ArrayList<>();
        for(int num:nums){
            //二进制最后一位是0
            if((num&1)==0){
                list.add(num);
            }
        }
        list.sort((o1, o2) -> o2-o1);
        int res=Integer.MIN_VALUE;
        int temp=list.get(0);
        for(int i=1;i<list.size();i++){
           //两数依次相与
            temp=temp&list.get(i);
            // 计算最后一位1的位置
            int position = 0;
            int count = 1;
            int temp2=temp;
            while (temp2 != 0) {
                if ((temp2 & 1) == 1) {
                    position = count;
                    break;
                }
                temp2 >>= 1;
                count++;
            }
            res=Math.max(res,position-1);
        }
        System.out.println(res);
    }


}
