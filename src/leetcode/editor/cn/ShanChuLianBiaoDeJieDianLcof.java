package leetcode.editor.cn;

//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。 
//
// 返回删除后的链表的头节点。 
//
// 注意：此题对比原题有改动 
//
// 示例 1: 
//
// 输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 
//
// 示例 2: 
//
// 输入: head = [4,5,1,9], val = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
// 
//
// 说明： 
//
// 
// 题目保证链表中节点的值互不相同 
// 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点 
// 
//
// Related Topics 链表 👍 290 👎 0

public class ShanChuLianBiaoDeJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new ShanChuLianBiaoDeJieDianLcof().new Solution();
        int[] input = new int[]{1, 3, 2};
        ListNode newnode1 = new ListNode(1);
        ListNode newnode2 = new ListNode(3);
        ListNode newnode3 = new ListNode(2);
        newnode1.next = newnode2;
        newnode2.next = newnode3;
        solution.deleteNode(newnode1,2);
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null)return head;
        if(head.val==val) return head.next;
        ListNode cur=head.next;
        ListNode former=head;
        while(cur!=null){
            if(cur.val==val){
                former.next=cur.next;
                cur=null;

            }else{
                former=cur;
                cur=cur.next;
            }
        }
        return head;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}