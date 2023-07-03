package leetcode.editor.cn;

//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
//
// Related Topics 栈 设计 👍 462 👎 0

import java.util.Stack;

public class BaoHanMinhanShuDeZhanLcof{
    public static void main(String[] args) {
        MinStack minStack = new BaoHanMinhanShuDeZhanLcof().new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        minStack.top();
        minStack.min();
    }

//leetcode submit region begin(Prohibit modification and deletion)

class MinStack {
        class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        }

    /** initialize your data structure here. */
    ListNode head;
    Stack<Integer> stack;
    public MinStack() {
        stack=new Stack<>();
        head=null;
    }
    
    public void push(int x) {
        stack.push(x);
        if(head==null){
            ListNode node=new ListNode(x);
            head=node;
        }else if(head.next==null){
            ListNode node=new ListNode(x);
            if(x<head.val){
                node.next=head;
                head=node;
            }else{
                head.next=node;
            }

        }
        else{
            ListNode pre=head;
            ListNode cur=head.next;
            while(cur!=null){
                if(x>=pre.val&&x<=cur.val){
                    ListNode node=new ListNode(x);
                    pre.next=node;
                    node.next=cur;
                    break;
                }
                if(x<pre.val){
                    ListNode node=new ListNode(x);
                    node.next=head;
                    head=node;
                    pre=cur;
                    cur=cur.next;
                    break;
                }
                if(x>cur.val&&cur.next==null){
                    ListNode node=new ListNode(x);
                    cur.next=node;
                    pre=cur;
                    cur=cur.next;
                    break;
                }
                pre=cur;
                cur=cur.next;

            }

        }
    }
    
    public void pop() {
        int x=stack.peek();
        stack.pop();
        if(head==null)return;
        if(head.val==x){
            head=head.next;
            return;
        }
        ListNode cur=head.next;
        ListNode pre=head;
        while(cur!=null){
            if(cur.val==x){
                pre.next=cur.next;
                return;
            }
            pre=cur.next;
            cur=cur.next;
        }
        return ;
    }
    
    public int top() {
       return  stack.peek();
    }
    
    public int min() {
        return head.val;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}