package leetcode.editor.cn.base.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/05/15/17:26
 * @Description:
 */
public class GuiBingSort {
    public static int [] mergeSort(int[] arr){
        if(arr.length<=1){
            return arr;
        }
        int middle=arr.length/2;
        int [] arr1= Arrays.copyOfRange(arr,0,middle);
        int [] arr2= Arrays.copyOfRange(arr,middle,arr.length);
        return merge(mergeSort(arr1),mergeSort(arr2));
    }
    public static int [] merge(int[] arr1,int[] arr2){
        int [] sorted_arr=new int[arr1.length+arr2.length];
        int idx_sorted=0,idx1=0,idx2=0;
        while(idx1<arr1.length&&idx2<arr2.length){
            if(arr1[idx1]<=arr2[idx2]){
                sorted_arr[idx_sorted]=arr1[idx1];
                idx1++;
                idx_sorted++;
            }else{
                sorted_arr[idx_sorted]=arr2[idx2];
                idx2++;
                idx_sorted++;
            }
        }
        if(idx1<arr1.length){
            while(idx1<arr1.length){
                sorted_arr[idx_sorted]=arr1[idx1];
                idx1++;
                idx_sorted++;
            }
        }else if(idx2<arr2.length){
            while(idx2<arr2.length){
                sorted_arr[idx_sorted]=arr2[idx2];
                idx2++;
                idx_sorted++;
            }
        }
        return sorted_arr;
    }
    public static void main(String[] args){
        int[] arr=new int[]{2,3,5,16,1};
        int[] mergesort = mergeSort(arr);
        for(int c:mergesort){
            System.out.println(c);
        }
    }

}
