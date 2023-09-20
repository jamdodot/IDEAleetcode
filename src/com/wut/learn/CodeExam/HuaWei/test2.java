package com.wut.learn.CodeExam.HuaWei;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/09/20/19:08
 * @Description:
 */
public class test2 {
    /**
     * 4 4
     * 1 1 1 0
     * 1 1 1 0
     * 0 0 1 0
     * 0 1 1 1
     */
    static int step=Integer.MAX_VALUE;
    static boolean used[][];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        int [][] nums=new int[m][n];
        used=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                nums[i][j]=in.nextInt();
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i][0]==1){
                BackTrace(nums,0, i,0);
            }
        }
        System.out.println(step);
    }

    public static void BackTrace(int [][] nums, int step1,int x, int y){
        if(nums[x][y]==1&&y==nums[0].length-1){
            step=Math.min(step,step1);
            return;
        }
        int [][] direction=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<direction.length;i++){
            int nx=x+direction[i][0];
            int ny=y+direction[i][1];
            if(nx>=0&&nx<nums.length&&ny>=0&&ny<nums[0].length&&nums[nx][ny]==1&&!used[nx][ny]){
                used[x][y]=true;
                BackTrace(nums,step1+1,nx,ny);
                used[x][y]=false;
                step1--;
            }
        }
    }

}
