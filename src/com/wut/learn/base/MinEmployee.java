package com.wut.learn.base;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/05/16/11:03
 * @Description:
 */
public class MinEmployee {
    public static void main(String []args){
        int[] input={0,1,1,1,2, 2, 2, 2, 3};
        System.out.println(calculate(input));
    }
    public static  int calculate(int [] input){
        int res=0;
        int [] count =new int[1000];
        for(int c:input){
            count[c]+=1;
        }
        for(int i=0;i<count.length;i++){
            if(count[i]==0){
                continue;
            }
            if(i==0&&count[i]==1){
                res+=1;
                continue;
            }
            int temp=count[i]/(i+1);
            res+=temp*(i+1);
            if (count[i]%(i+1)!=0) {
                res+=(i+1);
            }
        }
        return res;
    }

}
