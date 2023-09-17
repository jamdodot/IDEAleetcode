package com.wut.learn.CodeExam;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/16/19:57
 * @Description:
 */
public class lsltest1 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System .in);
        int day = in. nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        Map<String, Integer> mp = new HashMap<>() ;
        for(int i=0;i<day;i++){
            String name = in.next();
            int cnt = in. nextInt();
            mp . put (name , mp. getOrDefault(name,  0) + cnt);
        }
        int gCnt = 0;
        for (String s : mp. keySet()) {
            int value = mp.get(s);
            if(value % y == 0) gCnt += value/y;
            else
            gCnt += value/y + 1;
        }
        int res=0;
        res = gCnt % x == 0?gCnt/x:gCnt/x+1;
        System.out.println(res);
    }


}
