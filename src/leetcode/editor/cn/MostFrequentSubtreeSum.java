package leetcode.editor.cn;

//给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [5,2,-3]
//输出: [2,-3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入: root = [5,2,-5]
//输出: [2]
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 157 👎 0

import java.util.*;
import java.util.stream.Collectors;

public class MostFrequentSubtreeSum{
    public static void main(String[] args) {
        Solution solution = new MostFrequentSubtreeSum().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)


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
     Map<Integer,Integer> res=new HashMap<>();
     Set<Object> finalRes=new HashSet<>();
    public int [] findFrequentTreeSum(TreeNode root) {

        traverse(root);
        int i = 0;
        int length = res.size();
        Collection<Integer> c = res.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        int idx = (int) obj[obj.length - 1];
        System.out.println();
        for (Map.Entry entry : res.entrySet()) {
            if ((int) entry.getValue() == idx) {
                finalRes.add(entry.getKey());
            }

        }
        Object [] res_array =finalRes.toArray();
        int [] res_final=new int [res_array.length];
        for(Object d:res_array){
            res_final[i++]=(int) d;
        }
        return res_final;
    }
    int traverse(TreeNode root){
        if(root==null) return 0;
        int left= traverse(root.left);
        int right=traverse(root.right);
        int tmp=root.val+left+right;
        res.put(tmp,res.getOrDefault(tmp,0)+1);
        return root.val+left+right;
     }
}
//leetcode submit region end(Prohibit modification and deletion)

}