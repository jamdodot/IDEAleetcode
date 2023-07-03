package leetcode.editor.cn.CodeExam;

import java.util.Scanner;

public class Main {
    static int res=0;
    static int  min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int num=sc.nextInt();
        TreeNode[] treeNodes=new TreeNode[num];
        for(int i=0;i<num;i++){
            treeNodes[i]=new TreeNode(i+1);
        }
        int n=num-1;
        while(n>0){
            int son=sc.nextInt();
            int father=sc.nextInt();
            if(treeNodes[father-1].left==null){
                treeNodes[father-1].left=treeNodes[son-1];
            }else{
                treeNodes[father-1].right=treeNodes[son-1];
            }
            n--;
        }

        traverse_min(treeNodes[0],num);
        traverse(treeNodes[0],num);
        System.out.println(min+" "+res);
    }
    public static void traverse(TreeNode root,int node_num){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }
        int left=dfs(root.left);
        int right=node_num-left;
        if(Math.abs(left-right)==min){
            res++;
        }
        int right_2=dfs(root.right);
        int left_2=node_num-right_2;
        if(Math.abs(left_2-right_2)==min){
            res++;
        }
        traverse(root.left,node_num);
        traverse(root.right,node_num);

    }

    public static void traverse_min(TreeNode root,int node_num){
        if(root==null){
            return;
        }
        if(root.left==null||root.right==null){
            return;
        }
        int left=dfs(root.left);
        int right=node_num-left;
        min=Math.min(min,Math.abs(left-right));
        traverse_min(root.left,node_num);
        traverse_min(root.right,node_num);

    }
    public static int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        int sum=left+right+1;
        return sum;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
