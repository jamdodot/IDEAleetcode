package leetcode.editor.cn;

//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
// 
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1021 👎 0

public class ZhongJianErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
        
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
public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);

    }
    public TreeNode build(int[] preorder, int[] inorder,int pres,int pree,int ins,int ine){

        if (pres>pree||ins>ine){
            return null;
        }
        int val=preorder[pres];
        int mid =ins;
        for(int i=ins;i<inorder.length;i++){
            if (inorder[i]==val){
                mid=i;
            }
        }
        TreeNode t=new TreeNode(val);
        t.left=build(preorder,  inorder,pres+1,pres+(mid-ins),ins,mid-1);  //左子树的前序终点比较难
        t.right=build(preorder, inorder,pres+(mid-ins)+1,pree,mid+1,ine);
        return t;


    }

}
//leetcode submit region end(Prohibit modification and deletion)

}