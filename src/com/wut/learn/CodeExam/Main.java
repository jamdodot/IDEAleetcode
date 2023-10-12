package com.wut.learn.CodeExam;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static String decompressString(String input) {
        Deque<String> deque=new ArrayDeque<>();
        StringBuilder res=new StringBuilder();
        int n=input.length();
        for(int i=0;i<n;i++){
           char c=input.charAt(i);
           if(c=='('||c==')'){
               deque.offer(c+"");
           }
           if(Character.isLetter(c)){
               deque.offer(c+"");
           }
           if(c=='>'){
               continue;
           }
           if(c=='<') {
               continue;
           }
           if(Character.isDigit(c)){
               int count = 0;
               while (Character.isDigit(input.charAt(i))) {
                   count = count * 10 + (input.charAt(i) - '0');
                   i++;
               }
               StringBuilder sb =new StringBuilder();
               StringBuilder sb2 =new StringBuilder();
               while(!deque.isEmpty()){
                   String temp=deque.pollLast();
                   if(temp.equals("(")){
                       break;
                   }
                   if(!temp.equals(")")){
                       sb.append(temp);
                   }
               }
               sb.reverse();
               for(int j=0;j<count;j++){
                  sb2.append(sb);
               }
               deque.offer(sb2.toString());
           }

        }
        while(!deque.isEmpty()){
            if(!deque.peekFirst().equals("(")&&!deque.peekFirst().equals(")")){
                res.append(deque.pollFirst());
            }else{
                deque.pollFirst();
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String input = "(a(bd(c)<2>))";
        String decompressedString = decompressString(input);
        System.out.println(decompressedString);
    }
}