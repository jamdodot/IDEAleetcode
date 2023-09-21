package com.wut.learn.CodeExam.XieCheng;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/21/20:27
 * @Description:
 */
public class test22 {
    /**
     * 3
     * ab
     * ba
     * abc
     * aaa
     * aaaa
     * abcd
     * @param args
     */
    public  static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
       while(n-->0){
           String s=in.next();
           String t=in.next();
           if(fun(s,t)){
               System.out.println("Yes");
           }else{
               System.out.println("No");
           }
       }
    }
    public static boolean fun(String s, String t){
        Map<Character,Character>  record =new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(record.containsKey(s.charAt(i))&&
                    record.getOrDefault(s.charAt(i),'#')!=t.charAt(i)){
                return false;
            }
            record.put(s.charAt(i),t.charAt(i));
        }
        return true;
    }

}
