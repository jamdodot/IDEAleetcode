package com.wut.learn.CodeExam.XieCheng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/07/19:53
 * @Description:
 */
public class test3 {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();
            int[] nums = new int[num];
            for (int j = 0; j < num; j++) {
                nums[j] = in.nextInt();
            }
            System.out.println(fun(nums, l, r));

        }
    }
    public static int fun(int[]nums,int l,int r){
        int n=nums.length;
        int sum=0;
        int res1=0;
        int res2=0;
        for(int num:nums){
           sum+=num;
           if(num>r){
               res2+=num-r;
           }
           if(num<l){
               res1+=l-num;
           }
        }
        if(sum<l*n||sum>r*n) return -1;
        return Math.min(res1,res2);
    }

//        int total=in.nextInt();
//        int count = 0;
//        int n,l,r;
//        while (total-->0){
//            n=in.nextInt();
//            l=in.nextInt();
//            r=in.nextInt();
//           int ans[]=new int[n];
//           for(int i=0;i<n;i++){
//               ans[i]=in.nextInt();
//           }
//            Arrays.sort(ans);
//           if(ans[n-1]<l||ans[0]>r){
//               count=-1;
//           }
//           else if (ans[0]>=l&&ans[n-1]<=r) count=0;
//           else {
//               count=0;
//               int left=0,right=n-1;
//               if(ans[0]<=l&&ans[n-1]>=r){
//                   while(left<right){
//                       if(ans[left]>=l&&ans[right]<=r) break;
//                       int leftDis=l-ans[left];
//                       int rightDis=ans[right]-r;
//                       if(leftDis==rightDis){
//                           count+=leftDis;
//                       }else if(leftDis<rightDis) {
//                          if(ans[left]+rightDis>r){
//                              count=-1;
//                              break;
//                          }
//                          count +=rightDis;
//                       }
//                       else{
//                           if(ans[right]-leftDis<l){
//                               count=-1;
//                               break;
//                           }
//                           count+=leftDis;
//                       }
//                       left++;
//                       right--;
//
//
//                   }
//               }else if(ans[0]<=l&&ans[n-1]<=r){
//                   while(left<right){
//                       if(ans[left]>=l&&ans[right]<=r) break;
//                       int rightDis=ans[right]-r;
//                       if(ans[left]+rightDis>r){
//                           count=-1;
//                           break;
//                       }else{
//                           count+=rightDis;
//                       }
//                       left++;
//                       right--;
//                   }
//
//               }
//           }
//            System.out.println(count);
//        }

}
