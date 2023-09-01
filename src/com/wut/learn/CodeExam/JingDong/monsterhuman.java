package com.wut.learn.CodeExam.JingDong;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/26/19:51
 * @Description:
 */
public class monsterhuman {
    public static void main(){
        int userCount=0;
        String[] res=null;
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            userCount=in.nextInt();
            int roundCount=in.nextInt();
            in.nextLine();
            int[] power= new int[userCount];
            String[]role=new String[userCount];
            res=new String[userCount];
            for(int i=0;i<userCount;i++){
                res[i]="Y";
                String str= in.nextLine();
              String[] strs =str.split(" ");
              role[i]=strs[0];
                power[i]=Integer.parseInt(strs[1]);
            }
            for(int i=0;i<roundCount;i++){
                String str= in.nextLine();
                String[] strs =str.split(" ");
                int role1 =Integer.parseInt(strs[0])-1;
                int role2 =Integer.parseInt(strs[1])-1;
                if(!role[role1].equals("human")){
                    int temp=role1;
                    role1=role2;
                    role2=temp;
                    String tempStr=strs[2];
                    strs[2]=strs[3];
                    strs[3]=tempStr;
                }
                if(strs[2].equals("Y")) {
                    fireF(res, str, power, role1, role2);
                } else{
                    if(strs[3].equals("Y")){
                        if(power[role1]>power[role2]){
                            res[role2]="N";
                        }
                    }
                }

            }
            for(int i=0;i<userCount;i++){
                System.out.println(res[i]);
            }

        }




    }
    public static void fireF(String[] res,String str,int [] power,int role1,int role2){
        if(power[role1]>power[role2]) {
            res[role2] = "N";
        }else if(power[role1]<power[role2]){
           res[role1]  ="N";

        }else{
            res[role2]="N";
            res[role1]="N";
        }
    }
}
