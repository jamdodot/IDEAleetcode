package leetcode.editor.cn;

//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 996 👎 0

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node2.right=node4;
        solution.binaryTreePaths(node1);
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public static  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    List<String> res=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null) return res;
        dfs(String.valueOf(root.val),root);
        return res;
    }
    private void dfs(String path,TreeNode root){
        if(root.left==null&&root.right==null){
            res.add(path);
        }
        if(root.left!=null){
            String sLeft=new String(path+"->"+root.left.val);
            dfs(sLeft,root.left);
        }
        if(root.right!=null){
            String sRight=new String(path+"->"+root.right.val);
            dfs(sRight,root.right);
        }
//        if(root.left==null&&root.right==null){
//            res.add(path);
//            return;
//        }
//        if(root.left!=null){
//            dfs(path+"->"+root.left.val,root.left);
//        }
//        if(root.right!=null){
//            dfs(path+"->"+root.right.val,root.right);
//        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}