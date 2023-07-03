package leetcode.editor.cn;

//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。 
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-
//tree/ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 236 👎 0

import java.util.*;

public class ErChaShuDeShenDuLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeShenDuLcof().new Solution();
        TreeNode n1=new TreeNode(2);
        TreeNode n2=new TreeNode(3);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        System.out.println(solution.maxDepth(n1));
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
    public int maxDepth(TreeNode root) {
//        Deque<TreeNode> deque=new ArrayDeque<>();
//        deque.offer(root);
//        if (root==null) return 1;
//        int depth=0;
//        while(!deque.isEmpty()){
//            List<TreeNode> list=new ArrayList<>();
//            while(!deque.isEmpty()){
//                list.add(deque.pop());
//            }
//            depth++;
//            for(TreeNode c:list){
//                if(c.left!=null) deque.add(c.left);
//                if(c.right!=null) deque.add(c.right);
//            }
//            list.clear();
//        }
//        return depth;
        return  root==null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}