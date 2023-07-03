package leetcode.editor.cn;

//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
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
// Related Topics 树 广度优先搜索 二叉树 👍 265 👎 0

import java.util.*;

public class CongShangDaoXiaDaYinErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
        
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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {

    public int[] levelOrder(TreeNode root) {
        Deque<TreeNode> queue= new ArrayDeque<>();
        if(root==null) return new int[]{};
        queue.add(root);
        List<Integer> list=new ArrayList<>();
        while(!queue.isEmpty()){
            if(queue.peek().left!=null){
                queue.add(queue.peek().left);
            }if(queue.peek().right!=null){
                queue.add(queue.peek().right);
            }
            list.add(queue.peek().val);
            queue.pop();
        }
        int [] res=new int[list.size()];
        int i=0;
        for(int elem:list){
            res[i]=elem;
            i++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}