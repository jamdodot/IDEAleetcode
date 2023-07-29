package leetcode.editor.cn;

//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 909 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeRightSideView{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
        
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
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> deque=new ArrayDeque<>();
        List<Integer> res=new ArrayList<>();
        List<List<Integer>> record=new ArrayList<>();
        if(root==null){
            return res;
        }
        deque.add(root);
        while(!deque.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int size=deque.size();
            for(;size>0;size--){
                TreeNode pop = deque.pop();
                temp.add(pop.val);
                if(pop.left!=null){
                    deque.add(pop.left);
                }
                if(pop.right!=null){
                    deque.add(pop.right);
                }

            }
            record.add(temp);
        }
        for(List<Integer> temp:record){
            res.add(temp.get(temp.size()-1));
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}