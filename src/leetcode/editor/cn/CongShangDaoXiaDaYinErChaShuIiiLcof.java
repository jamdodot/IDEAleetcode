package leetcode.editor.cn;

//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 283 👎 0

import java.util.*;

public class CongShangDaoXiaDaYinErChaShuIiiLcof{
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
        
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
public  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque =new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) {
            return res;
        }
        deque.add(root);
        while(!deque.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int size=deque.size();
            for(;size>0;size--){
                TreeNode node=deque.pop();
                list.add(node.val);
                if(node.left!=null){
                    deque.add(node.left);
                }if(node.right!=null){
                    deque.add(node.right);
                }
            }
            res.add(list);
        }
        for(int i=1;i<res.size();i+=2){
            Collections.reverse(res.get(i));
        }
        return res;



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}