package leetcode.editor.cn;

//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 678 👎 0

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class MinimumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
        
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
public class TreeNode {
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
    public int minDepth(TreeNode root) {
        Deque<TreeNode> deque=new ArrayDeque<>();
        if(root==null) return 0;
        deque.offer(root);
        int depth=0;
        while(!deque.isEmpty()){
            int size=deque.size();
            depth++;
            for(int i=0;i<size;i++){
                TreeNode pop = deque.pop();
                if(pop.left==null&&pop.right==null){
                    return depth;
                }
                if(pop.left!=null) deque.add(pop.left);
                if(pop.right!=null) deque.add(pop.right);
            }
        }
        return depth;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}