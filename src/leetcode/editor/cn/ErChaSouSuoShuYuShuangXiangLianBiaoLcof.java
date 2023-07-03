package leetcode.editor.cn;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。 
//
// 
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例： 
//
// 
//
// 
//
// 
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。 
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。 
//
// 
//
// 
//
// 
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。 
//
// 
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
//to-sorted-doubly-linked-list/ 
//
// 注意：此题对比原题有改动。 
//
// Related Topics 栈 树 深度优先搜索 二叉搜索树 链表 二叉树 双向链表 👍 662 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

public class ErChaSouSuoShuYuShuangXiangLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuYuShuangXiangLianBiaoLcof().new Solution();
        Node n1=new Node(4);
        Node n2=new Node(2);
        Node n3=new Node(5);
        Node n4=new Node(1);
        Node n5=new Node(3);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        System.out.println(solution.treeToDoublyList(n1));
    }

//leetcode submit region begin(Prohibit modification and deletion)

public static class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
    public Node treeToDoublyList(Node root) {
//            if(root==null) return root;
//            String res=StrTree(root);
//            String[] strArr = res.split(",");
//            Deque<String> deque=new ArrayDeque<>();
//            for(String str :strArr ){
//                if(!str.equals("#")){
//                    deque.add(str);
//                }
//            }
//            Node node=new Node(Integer.parseInt(deque.pop()));
//            Node head=node;
//            Node cur=node;
//            int n=deque.size();
//            for(int i=1;i<=n;i++){
//                Node tmp= new Node(Integer.parseInt(deque.pop()));
//                cur.right=tmp;
//                tmp.left=cur;
//                cur=cur.right;
//            }
//            cur.right=head;
//            head.left=cur;
//            return head;
//    }
//    public String StrTree(Node root){
//        if(root==null) return "#";
//        String left=StrTree(root.left);
//        String right=StrTree(root.right);
//        String res=left+","+root.val+","+right;
//        return res;
//    }
        if(root==null) return root;
        Node pre= null;
        midSearch(root,pre);
        Node left_=root;
        while(left_.left!=null) left_=left_.left;
        left_.left=pre;
        pre.right=left_;
        return left_;

    }

    void midSearch(Node root,Node pre){

        if(root==null) return ;
        midSearch(root.left,pre);
        root.left=pre;
        if(pre!=null){
            pre.right=root;
        }
        pre=root;
        midSearch(root.right,pre);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}