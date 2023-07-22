package com.wut.learn.CodeExam.HuaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/04/12/19:48
 * @Description:
 */
public class HuaWeiTest2 {
    static List<Integer> res=new ArrayList<>();
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        String Strn=sc.nextLine();
        int n=Integer.parseInt(Strn);
        int n_=n;
        int [][] input=new int[n][3];
        while(n_>0){
            for(int i=0;i<n;i++){
                for(int j=0;j<3;j++){
                    input[i][j]=sc.nextInt();
                }
                n_--;
            }

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
        }
        //数组每一行第一个值为节点序号 第二个值为父节点 第二个值为-1的是根节点 第三个值为value 构建多叉树
        TreeNode[] nodes=new TreeNode[n];
        for(int i=0;i<n;i++){
            nodes[i]=new TreeNode(input[i][2]);
        }
        TreeNode head=null;
        for(int i=0;i<n;i++){
            if(input[i][1]==-1){
                head=nodes[i];
                continue;
            }
            int idx=input[i][1];
            nodes[idx].children.add(nodes[i]);
        }
        traverse(head);
        int max=Integer.MIN_VALUE;
        for(int cur:res){
            max=Math.max(max,cur);
        }
        for(int i=0;i<input.length;i++){
            max=Math.max(max,input[i][2]);
        }
        System.out.println(max);
    }
    public  static void traverse(TreeNode root){
        if(root==null){
            return;
        }
        backtrace(root,0);
        for(TreeNode node:root.children){
            traverse(node);
        }
    }
    public  static void backtrace(TreeNode root,int target){
        if(root==null){
            return;
        }
        target+=root.val;
        res.add(target);
        for(TreeNode node:root.children) {
            backtrace(node, target);
        }
        target-=root.val;
    }
    static class TreeNode {
        int val;
        List<TreeNode> children=new ArrayList<>();

        TreeNode(int x) { val = x; }
    }
}
//    public static void isExist(JingSanYunTest2.TreeNode root, int idx){
//        if (root.left==null&&root.right==null){
//            return;
//        }
//        traverse(root,idx);
//        isExist(root.left,idx);
//        isExist(root.right,idx);
//
//    }
//    public static int traverse(JingSanYunTest2.TreeNode root, int idx){
//        if (root==null){
//            return 0;
//        }
//        int left = traverse(root.left,idx);
//        int right = traverse(root.right,idx);
//        if(left==right){
//            flag[idx]=true;
//        }
//        return left+right+root.val;
//    }


