package leetcode.editor.cn.CodeExam.JingSanYun;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/06/02/19:35
 * @Description:
 */
public class JingSanYunTest2 {
    static boolean [] flag;
    public static void main(String[] args) {
        /**
         * 首先按照从上到下、从左到右的顺序输入一棵满二叉树中每一个结点对应的权重，例如输入1、1、2表示二叉树的根结点的权重为1，它的左、右两个子节点的权重分别为1和2。
         *
         * 然后判断该满二叉树中是否存在这样的非叶子结点：它的左子树上所有结点的权重之和等于右子树上所有结点的权重之和。
         *
         * 现在给你一棵满二叉树的所有结点的权重，请编写一个程序，寻找是否存在满足要求的非叶子结点，如果存在输出“Yes”，否则输出“No”。
         */
        /**
         * 多组输入。
         *
         * 第1行输入一个正整数T表示测试数据的数量。(T<=100)
         *
         * 接下来T行对应T组输入，每组输入数据占一行，该行包含n个正整数（n满足2^k-1），两两之间用空格隔开，1<n<=1000。
         */
        Scanner sc = new Scanner(System.in);
        String rowStr = sc.nextLine();
        int row = Integer.parseInt(rowStr);
        flag=new boolean[row];
        for(int i=0;i<row;i++){
            flag[i]=false;
        }
        List<List<Integer>> inputs= new ArrayList<>();
        for(int i=0;i<row;i++){
            List<Integer> input = new ArrayList<>();
            //读取一行
            String s = sc.nextLine();
            String[] arr = s.trim().split(" ");
            for(String str:arr){
                input.add(Integer.parseInt(str));
            }
            inputs.add(input);
        }
        for(int i=0;i<row;i++){
            TreeNode root = buildTree(inputs.get(i));
            isExist(root,i);
            if (flag[i]) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    /**
     * 然后判断该满二叉树中是否存在这样的非叶子结点：
     * 它的左子树上所有结点的权重之和等于右子树上所有结点的权重之和。
     * @param root
     * @return
     */
    public static int isExist(TreeNode root,int idx){
        if (root.left==null&&root.right==null){
            return root.val;
        }
        int left=isExist(root.left,idx);
        int right=isExist(root.right,idx);
        if(left==right){
            flag[idx]=true;
        }
        return left+right+root.val;
    }

    //构建满二叉树
    public static TreeNode buildTree(List<Integer> input){
        TreeNode root = new TreeNode(input.get(0));
        //层次遍历法构建满二叉树
        Deque<TreeNode> deque =new ArrayDeque<>();
        deque.add(root);
        int inputIdx=1;
        while(inputIdx<input.size()){
            if(deque.peek().left==null){
                deque.peek().left=new TreeNode(input.get(inputIdx++));
                deque.add(deque.peek().left);
            }
            if(deque.peek().right==null){
                deque.peek().right=new TreeNode(input.get(inputIdx++));
                deque.add(deque.peek().right);
            }
            if(deque.peek().left!=null&&deque.peek().right!=null){
                deque.poll();
            }
        }
        return root;
    }
    static class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
}
