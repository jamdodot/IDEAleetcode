package leetcode.editor.cn;

//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 / \ 2 2 / \ / \ 3 4 4 3 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 / \ 2 2 \ \ 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 430 👎 0

public class DuiChengDeErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new DuiChengDeErChaShuLcof().new Solution();
        TreeNode n1=new TreeNode(2);
        TreeNode n2=new TreeNode(3);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(4);
        TreeNode n7=new TreeNode(5);
        TreeNode n8=new TreeNode(8);
        TreeNode n9=new TreeNode(9);
        TreeNode n10=new TreeNode(8);
        TreeNode n11=new TreeNode(9);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n7;
        n3.right=n6;
        n5.left=n8;
        n5.right=n9;
        n7.left=n10;
        n7.right=n11;
        System.out.println(solution.testStr(n1));

    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)) return true;
        String leftStr=getStr(root.left);
        String rightStr=getRightStr(root.right);
        return leftStr.equals(rightStr);
    }
    String getStr(TreeNode root){
        if(root==null) return "#";
        String left=getStr(root.left);
        String right=getStr(root.right);
        String res=left+","+right+","+root.val;
        return res;
    }
    String getRightStr(TreeNode root){
        if(root==null) return "#";
        String left=getRightStr(root.right);
        String right=getRightStr(root.left);
        String res=left+","+right+","+root.val;
        return res;
    }
    String testStr(TreeNode root){
        if(root==null) return "";
        String left=testStr(root.left);
        String right=testStr(root.right);
        String res=left+root.val+right;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}