package leetcode.editor.cn.CodeExam.HuaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/04/12/18:44
 * @Description:
 */
public class HuaWeiTest1 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        String [] input_tmp=s1.trim().split(" ");
        int [] input=new int[input_tmp.length];
        double target=Long.parseLong(s2);
        for(int i=0;i<input_tmp.length;i++){
            input[i]=Integer.parseInt(input_tmp[i]);
        }
        //寻找一个阈值使得每个数组内的值都不超过这个值，并且所有总合小于等于target
        double left=0;
        double right=target;
        double mid=0;
        List<Double> res =new ArrayList<>();
        while(left<=right){
            mid=left+(int)(right-left)/2;
            double sum=check(input,mid,target);
            if(sum<0){
                right=mid-1;
            }else if(sum>0){
                res.add(mid);
                left=mid+1;
            }else{
                res.add(mid);
                left=mid+1;
            }
        }
        int sum_=0;
        for(int i=0;i<input.length;i++){
            sum_+=input[i];
        }
        if(res.size()==0){

            System.out.println(0);
        }else{
            if(sum_<target){
                System.out.println(-1);
            }else{
                double max=Double.MIN_VALUE;
                for(double res1:res){
                    max=Math.max(max,res1);
                }
                System.out.println((int)max);
            }

        }

    }
    static double check(int [] input,double mid,double target){
        for(int i=0;i<input.length;i++){
            if(input[i]>mid){
                target-=mid;
            }else{
                target-=input[i];
            }
        }
        return target;
    }
}
