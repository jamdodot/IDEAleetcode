package com.wut.learn.CodeExam.Yongyou;

import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/21/18:57
 * @Description:
 */
public class YongYou1 {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(6);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        ListNode listNode = groupSort(node1, 2);
    }
    public static class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }
    public static ListNode groupSort (ListNode head, int n) {
        // 输入一个链表进行分组 n代表每组的个数
        // 每组value大的排前面 若n大于链表长度或最后剩余不到n个 剩余的保持原有位置不变
        // 每个节点value大的排在前面
        // write code here
        // 1. 先将链表分组
        // 2. 对每组进行排序
        // 3. 将每组连接起来
        // 4. 返回新的链表
        if(head==null||head.next==null||n<2){
            return head;
        }
        ListNode origin=new ListNode(0);
        origin.next=head;
        ListNode pre=origin,cur=head,temp;
        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }
        for(int i=0;i<len/n;i++){
            for(int j=1;j<n;j++){
                temp=cur.next;
                cur.next=temp.next;
                temp.next=pre.next;
                pre.next=temp;

            }
            pre=cur;
            cur=cur.next;
        }
        return origin.next;


    }
    public static ListNode sort(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=head;
        ListNode cur=head.next;
        ListNode pre=head;

        while(cur!=null){
            if(cur.val>newHead.val){
                pre.next=cur.next;
                cur.next=newHead;
                newHead=cur;
                cur=pre.next;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        return newHead;
    }
}
