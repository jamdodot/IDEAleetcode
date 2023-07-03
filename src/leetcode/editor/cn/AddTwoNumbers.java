package leetcode.editor.cn;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 9568 👎 0

public class AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode n1=new AddTwoNumbers().new ListNode(6);
        ListNode n2=new AddTwoNumbers().new ListNode(6);

        n1.next=n2;
        ListNode n4=new AddTwoNumbers().new ListNode(7);
        ListNode n5=new AddTwoNumbers().new ListNode(0);
        ListNode n6=new AddTwoNumbers().new ListNode(1);

        n4.next=n5;
        n5.next=n6;

        solution.addTwoNumbers(n1,n4);

    }

//leetcode submit region begin(Prohibit modification and deletion)

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
        int flag=0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1=l1;
        ListNode p2=l2;
        while(p1.next!=null&&p2.next!=null){
            p1.val=p1.val+p2.val+flag;
            flag=0;
            if(p1.val>=10){
                flag=p1.val/10;
                p1.val=p1.val%10;
            }
            p1=p1.next;
            p2=p2.next;
        }
        if(p1.next==null&&p2.next==null){
            p1.val=p1.val+p2.val+flag;
            if(p1.val>=10){
                flag=p1.val/10;
                p1.val=p1.val%10;
                if(flag!=0){
                    p1.next=new ListNode(flag);
                }
            }
        }else if(p1.next==null&&p2.next!=null){
            p1.val=p1.val+p2.val+flag;
            flag=0;
            if(p1.val>=10){
                flag=p1.val/10;
                p1.val=p1.val%10;
            }
            p1.next=p2.next;
            p1=p1.next;
            while(p1.next!=null){
                p1.val=p1.val+flag;
                flag=0;
                if(p1.val>=10){
                    flag=p1.val/10;
                    p1.val=p1.val-10;
                }
                p1=p1.next;

            }
            p1.val=p1.val+flag;
            flag=0;
            if(p1.val>=10){
                flag=p1.val/10;
                p1.val=p1.val%10;
                p1.next=new ListNode(flag);
            }

        }else if(p1.next!=null&&p2.next==null){
            p1.val=p1.val+p2.val+flag;
            flag=0;
            if(p1.val>=10){
                flag=p1.val/10;
                p1.val=p1.val%10;
                p1=p1.next;
            }
            while(p1.next!=null){
                p1.val=p1.val+flag;
                flag=0;
                if(p1.val>=10){
                    flag=p1.val/10;
                    p1.val=p1.val%10;
                }
                p1=p1.next;
            }
            p1.val=p1.val+flag;
            flag=0;
            if(p1.val>=10){
                flag=p1.val/10;
                p1.val=p1.val%10;
                p1.next=new ListNode(flag);
            }
        }
        return l1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}