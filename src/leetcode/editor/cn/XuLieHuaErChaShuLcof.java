package leetcode.editor.cn;

//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字
//符串反序列化为原始的树结构。 
//
// 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方
//法解决这个问题。 
//
// 
//
// 示例： 
// 
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-
//binary-tree/ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 383 👎 0

public class XuLieHuaErChaShuLcof{
    public static void main(String[] args) {
       Codec solution = new XuLieHuaErChaShuLcof().new Codec();
       TreeNode n1=new TreeNode(1);
       TreeNode n2=new TreeNode(2);
       TreeNode n3=new TreeNode(3);
       TreeNode n4=new TreeNode(4);
       TreeNode n5=new TreeNode(5);
       n1.left=n2;
       n1.right=n3;
       n3.left=n4;
       n3.right=n5;
       String res=solution.serialize(n1);
       solution.deserialize(res);
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
public class Codec {
    int left=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res=strTree(root);
        return res;

    }
    public String strTree(TreeNode root){
        if(root==null) return "#";
        String left=strTree(root.left);
        String right=strTree(root.right);
        String res=root.val+","+left+","+right;
        return res;
    }

    public TreeNode toTree(String[] strArray){
            if(strArray[left].equals("#")) {
                this.left++;
                return null;
            }
            TreeNode node= new TreeNode(Integer.parseInt(strArray[this.left]));
            this.left++;
            node.left=toTree(strArray);
            node.right=toTree(strArray);
            return node;

    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArray=data.split(",");
        this.left=0;
        TreeNode res=toTree(strArray);
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}