package com.wut.learn.CodeExam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/06/09/14:51
 * @Description:
 */


public class XiaoMitest1 {
    static List<List<Integer>> res=new ArrayList<>();
    public static void main(String[] args) {
        /**
         * 获取所有子数组
         */
        int[] arr = {1, 2, 3};
        List<Integer> aList=new ArrayList<Integer>();
        List<Integer> bList=new ArrayList<Integer>();
        List<Integer> input =new ArrayList<>();
        for(int c: arr){
            aList.add(c);
        }

        getSonSet1(0,aList,bList);


    }
    public static void getSonSet1(int i,List<Integer> aList,List<Integer> bList){
        if(i>aList.size()-1){
            if(bList.isEmpty()){
                System.out.print("@");
            }else {
                System.out.print(bList.get(0));
                for(int m=1;m<bList.size();m++){
                    System.out.print(","+bList.get(m));
                }
            }
            System.out.println();
        }else {
            bList.add(aList.get(i));
            getSonSet1(i+1, aList, bList);
            int bLen=bList.size();
            bList.remove(bLen-1);
            getSonSet1(i+1, aList, bList);
        }
    }

}
