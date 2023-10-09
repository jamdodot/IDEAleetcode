package com.wut.learn.CodeExam.TuHu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/10/09/19:33
 * @Description:
 */
public class test {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        //输入一个数组
        String s=in.nextLine();
        String[] arr=s.trim().split(" ");
        int[] nums=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            nums[i]=Integer.parseInt(arr[i]);
        }
        //数组值为边长  求能够组成有效三角形的个数
        System.out.println(countValidTriangles(nums));
    }
    public static int countValidTriangles(int[] lengths) {
        Arrays.sort(lengths); // 将边长数组按升序排序
        int count = 0;

        for (int i = 0; i < lengths.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < lengths.length - 1; j++) {
                while (k < lengths.length && lengths[i] + lengths[j] > lengths[k]) {
                    k++;
                }
                count += k - j - 1;
            }
        }

        return count;
    }

}
