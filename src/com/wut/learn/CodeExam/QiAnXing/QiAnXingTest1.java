package com.wut.learn.CodeExam.QiAnXing;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/06/03/19:27
 * @Description:
 */
public class QiAnXingTest1 {
    public static void main(String[] args){
        /**
         * 找零钱基本单位为1元、2元、5元、10元。输入一个找零金额，输出所有可能的找零组合。
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = {1,2,5,10};
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int coin:coins){
            for(int i=coin;i<=n;i++){
                dp[i] += dp[i-coin];
            }
        }
        System.out.println(dp[n]);

    }
    /**
     * 找零钱基本单位为1元、2元、5元、10元。输入一个找零金额，输出所有可能的找零组合。
     */

}
