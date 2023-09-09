package com.wut.learn.CodeExam.KeDa;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/09/14:43
 * @Description:
 */
public class test2 {
    /**
     * 112233444555
     * @param args
     */
    public static void main(String[]args){
        Scanner in =new Scanner(System.in);
        String input=in.nextLine();
        int count =1;
        StringBuilder compressed=new StringBuilder();
        for(int i=1;i<=input.length();i++){
            if(i<input.length()&&input.charAt(i)==input.charAt(i-1)){
                count++;
            }else{input.charAt(i-1);
                compressed.append(count).append(input.charAt(i-1));
                count=1;
            }
        }
        System.out.println(compressed.toString());

    }
}
