package com.wut.learn.CodeExam.HuaWei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/04/12/15:50
 * @Description:
 */
public class HuaWei2 {
    public static void main(String[] args){
        Set<Character> set =new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        Scanner sc =new Scanner(System.in);
        String s= sc.nextLine();
        String[] input=s.trim().split(" ");
        String[] out=new String[input.length];
        for(int i=0;i<input.length;i++) {
            StringBuilder sb = new StringBuilder(input[i]);
            StringBuilder sb_ = new StringBuilder();
            for (int j = 0; j < sb.length(); j++) {
                char tmp = sb.charAt(j);
                char tmp_=tmp;
                if (set.contains(Character.toLowerCase(tmp))) {
                     tmp_=Character.toUpperCase(tmp);
                }else{
                    tmp_=Character.toLowerCase(tmp);
                }
                sb_.append(tmp_);
            }
            out[i]=sb_.toString();
        }

        for(int i=0;i<out.length-1;i++){
            System.out.print(out[i]);
            System.out.print(" ");
        }
        System.out.println(out[out.length-1]);

    }
}
