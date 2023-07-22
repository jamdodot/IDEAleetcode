package com.wut.learn.base.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/06/09/14:30
 * @Description:
 */
public class QuickSort {//这种排序最后加入了递归，便于一次到位
    public static void sort(int[] arr, int head, int tail) {
        if(head>=tail||arr==null||arr.length<=1)return;
        int i=head,j=tail, pivot = arr[(head + tail) / 2];
        while(i<j){
            while (arr[i] < pivot) {
                ++i;
            }
            //当数组大于基准 循环结束后 相当于j所处的位置的值为小于于基准的元素
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                //将指针继续移动
                ++i;
                --j;
            } else if (i == j) {
//如果i=j 那么说明本次排序已经结束 将i++ 如果这里不使用i++ 那么后面的sort(arr,i,tail)将改为arr(arr,i+1,tail)
                ++i;
            }
        }
        //继续将数组分割
        sort(arr, head, j);
        sort(arr, i, tail);
    }
    public static void main(String[] args) {
        int[] ints = {5, 3, 4, 1, 2};
        sort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }
}