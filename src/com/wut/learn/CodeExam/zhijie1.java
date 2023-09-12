package com.wut.learn.CodeExam;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/10/10:13
 * @Description:
 */
public class zhijie1 {
    // 辗转相除法求最大公约数
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // 计算最小公倍数
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static int countLCMPairs(int[] arr1, int[] arr2, int k) {
        int count = 0;

        for (int num1 : arr1) {
            for (int num2 : arr2) {
                int lcmValue = lcm(num1, num2);
                if (lcmValue == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 6};
        int[] arr2 = {2, 3, 3};
        int k = 6;

        int result = countLCMPairs(arr1, arr2, k);
        System.out.println("有 " + result + " 种取数方案使得最小公倍数等于 " + k);
    }

}
