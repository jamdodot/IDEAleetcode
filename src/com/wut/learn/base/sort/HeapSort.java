package com.wut.learn.base.sort;

/**
 * Created with IntelliJ IDEA.
 * @source https://www.bilibili.com/video/BV1fp4y1D7cj/
 * ?spm_id_from=333.337.search-card.all.click&vd_source=ecef026928cceca949842048a86f1203
 * @Author: sunshine
 * @Date: 2023/05/15/16:25
 * @Description:
 */
public class HeapSort {
    static int heapLen;

    /**
     * Swap the two elements of an array
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Build Max Heap
     *
     * @param arr
     */
    private static void buildMaxHeap(int[] arr) {
        for(int i=arr.length/2+1;i>=0;i--){
            heapify(arr,i);
        }
    }

    /**
     * Adjust it to the maximum heap
     *
     * @param arr
     * @param i
     */
    private static void heapify(int[] arr, int i) {
        int largest=i;
        int left=i*2+1;
        int right=i*2+2;
        if(left<heapLen&&arr[left]>arr[largest]){
            largest=left;
        }
        if(right<heapLen&&arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=i){
            swap(arr,largest,i);
            heapify(arr,largest);
        }
    }

    /**
     * Heap Sort
     *
     * @param arr
     * @return
     */
    public static int[] heapSort(int[] arr) {
        // index at the end of the heap
        heapLen=arr.length;
        buildMaxHeap(arr);
        for(int i=arr.length-1;i>=0;i--){
            swap(arr,0,i);
            heapLen-=1;
            heapify(arr,0);
        }
        return arr;
    }

    public static  void main(String[] args){
        int[] arr=new int[]{2,3,5,16,1};
        int[] heapSort = heapSort(arr);
        for(int c:heapSort){
            System.out.println(c);
        }
    }

}
