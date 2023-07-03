package leetcode.editor.cn;

//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 给定的树 A: 
//
// 3 / \ 4 5 / \ 1 2 给定的树 B： 
//
// 4 / 1 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
//
// Related Topics 树 深度优先搜索 二叉树 👍 713 👎 0

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashSet;

public class ShuDeZiJieGouLcof{
    public static void main(String[] args) {
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
        TreeNode n1=new TreeNode(1);

        TreeNode n5=new TreeNode(2);
        TreeNode n7=new TreeNode(5);


        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n6=new TreeNode(5);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n6;
        n5.right=n7;

        solution.isSubStructure(n1,n5);

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

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null) return false;
        return search(A,B);


    }
    private boolean compare(TreeNode A, TreeNode B){
        if(B==null) return true ;
        if(A==null) return false;
        return A.val==B.val&&compare(A.left, B.left)&&compare(A.right,B.right);
    }
    private Boolean search(TreeNode A,TreeNode B){
        if(A==null) return false;
        if(A.val==B.val&&compare(A,B))return true;
        return search(A.left,B)||search(A.right,B);
    }
//    String traverse(TreeNode root){
//        if(root==null)return "";
//        String left=traverse(root.left);
//        String right=traverse(root.right);
//        String strTree=left+""+right+""+root.val;
//        return strTree;
//
//    }
//    String traverse2(TreeNode root,String strTreeB,Boolean res){
//        if(root==null)return "";
//        String left=traverse2(root.left, strTreeB,this.res);
//        String right=traverse2(root.right,strTreeB,this.res);
//        if(root.val<0){
//            String strTree=left+""+right+"-"+root.val;
//        }
//        String strTree=left+""+right+""+root.val;
//        System.out.println(strTree);
//
//        if(strTreeB.equals(strTree)||strTreeB.indexOf(strTree)!=-1){
//            this.res=true;
//            return strTree;
//        }
//        return strTree;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}