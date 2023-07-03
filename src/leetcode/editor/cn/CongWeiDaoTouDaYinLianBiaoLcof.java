package leetcode.editor.cn;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
//
// Related Topics 栈 递归 链表 双指针 👍 389 👎 0

import java.util.Currency;
import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        int[] input = new int[]{1, 3, 2};
        ListNode newnode1 = new ListNode(1);
        ListNode newnode2 = new ListNode(3);
        ListNode newnode3 = new ListNode(2);
        newnode1.next = newnode2;
        newnode2.next = newnode3;
        solution.reversePrint(newnode1);
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int[] reversePrint(ListNode head) {

            int len = 0;
            ListNode tmp = head;
            while (tmp != null) {
                len++;
                tmp = tmp.next;
            }
            int[] res = new int[len];
            if (head == null) {
                return res;
            }
            ListNode new_head = reverse(head);
            int i = 0;
            while (new_head != null) {
                res[i] = new_head.val;
                new_head = new_head.next;
                i++;
            }
            return res;
        }

        public ListNode reverse(ListNode head) {

            ListNode former = head;
            ListNode later = head.next;
            head.next = null;
            while (later != null) {
                ListNode tmp = later.next;
                later.next = former;
                former = later;
                later = tmp;
            }
            return former;
        }


//            ListNode tmp = head;
//            int len = 0;
//            while (tmp != null) {
//                len++;
//                tmp = tmp.next;
//            }
//            int[] res = new int[len];
//            Stack<Integer> stack = new Stack();
//            if (head == null) {
//                return res;
//            }
//            while (head != null) {
//                stack.push(head.val);
//                head = head.next;
//            }
//            int i = 0;
//            while (stack.size() != 0) {
//                res[i] = stack.pop();
//                i++;
//            }
//            return res;

    }

//leetcode submit region end(Prohibit modification and deletion)

}