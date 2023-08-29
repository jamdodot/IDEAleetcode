package com.wut.learn.CodeExam.Yongyou;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/21/20:04
 * @Description:
 */
public class Yongyou2 {
    public ArrayList<ArrayList<String>> build(String[] source){
        ArrayList<ArrayList<String>> res=new ArrayList<>();
        Set<String> child   =new HashSet<>();
        for(String s: source){
            String[]pc=s.split(",");
            child.add(pc[1]);
        }
        String root=null;
        for(String s:source){
            String []pc =s.split(",");
            if(!child.contains(pc[0])){
                root=pc[0];
                break;
            }
        }
        Queue<String> queue=new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<String> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                String head = queue.poll();
                for(String s:source){
                    String[]pc=s.split(",");
                    if(pc[0].equals(head)){
                        queue.offer(pc[1]);
                    }
                }
                list.add(head);
            }
            res.add(list);
        }
        return res;
    }
}
