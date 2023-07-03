package leetcode.editor.cn;

//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
//
// Related Topics 递归 链表 👍 327 👎 0

public class HeBingLiangGePaiXuDeLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
        
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode newlist=null;
        if(l2.val<l1.val){
            newlist=l2;
            l2=l2.next;
            newlist.next=null;
        }else{
            newlist=l1;
            l1=l1.next;
            newlist.next=null;
        }
        ListNode cur=newlist;
        while(l1!=null&&l2!=null){
            if(l2.val<l1.val){
                cur.next=l2;
                l2=l2.next;
                cur=cur.next;
                cur.next=null;
            }else{
                cur.next=l1;
                l1=l1.next;
                cur=cur.next;
                cur.next=null;
            }
        }
        if(l1!=null){
            cur.next=l1;
        }else{
            cur.next=l2;
        }


        return newlist;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}