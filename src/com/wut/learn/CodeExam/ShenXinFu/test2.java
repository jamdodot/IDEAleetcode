package com.wut.learn.CodeExam.ShenXinFu;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/06/19:42
 * @Description:
 */
public class test2 {
    //找出不含有重复数字的最长子数组  不转换为数字
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if (s.equals("") || s.trim().equals("") || s.length() == 0) {
            System.out.println(0);
            return;
        }
        String[] arr = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s1 : arr) {
            if (!s1.trim().equals("")) {
                sb.append(s1);
            }
        }
        int n = arr.length;
        int[] input = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            input[i] = Integer.parseInt(sb.charAt(i) + "");
        }
        List<Integer> list = Arrays.stream(input).boxed().collect(Collectors.toList());
        int[] dp = new int[list.size() + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 2; i <= list.size(); i++) {
            if (list.get(i - 1) < list.get(i - 2)) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}

//        long res = fun(input);
//        System.out.println(res);
//        int left = 0;
//        int right = 0;
//        int max = 0;
//        int[] count = new int[100000];
//        while(right < n){
//            count[input[right]]++;
//            while(count[input[right]] > 1){
//                count[input[left]]--;
//                left++;
//            }
//            max = Math.max(max, right - left + 1);
//            right++;
//        }
//        System.out.println(max);

    //}
//    public static long fun(int[] nums){
//        HashSet<Integer> set = new HashSet<>();
//        long max=0;
//        int left=0;
//        int right=0;
//        while(right<nums.length) {
//            if(!set.contains(nums[right])) {
//                set.add(nums[right]);
//                max = Math.max(max, right - left + 1);
//                right++;
//            }else{
//                set.remove(nums[left]);
//                left++;
//            }
//
//        }
//        return max;
//    }
//}
