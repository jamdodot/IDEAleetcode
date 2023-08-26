package com.wut.learn.CodeExam.ELeMa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/08/25/19:34
 * @Description:
 */
public class test1 {
    /**
     * 小红有一个长度为n的环，a1 和a2相邻，a2 和a3相邻，an
     * 和a1相邻。如果环中存在相邻的数字相等，那么就会立即删除其中一个数
     * 字，直到环中不存在相邻的数字相等为止。小红每次操作可以删除其中一个数，如果删除后出现相邻数字相同，那么可以立即删除相邻的数字中的一一个。
     * 例如，一个环[1,2,3, 2]，如果删除数字3,那么环会立即自动
     * 删除其中一个2,变为[1,2]。如果再删除数字2，那么环变为
     * [1], 因为长度为1的环，1不和自己相邻。小红想知道最多可以执行多少次操作。用例：
     * 4
     * 1 2 3 2
     * 输出：4
     * 说明
     * 先删除a4，变为[1,2,3]， 接下来不会触发自动删除，可
     * 以执行3次删除操作，删除A1,a2,A3，总共4次操作。
     */

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode head = new ListNode(scanner.nextInt());
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(scanner.nextInt());
            current.next.forward = current;
            current = current.next;
        }
        current.next = head;
        head.forward = current;
        int result = maxOperations(head);
        System.out.println(result);
    }

    public static int maxOperations(ListNode head) {
        int result = 0;
        ListNode current = head;
        ListNode flag=null;
        int count=0;
        while(current.next!=current&&current.next!=current.forward&&current!=flag) {
            if(current.forward.val!=current.next.val) {
                ListNode temp = current.forward;
                current.next.forward = temp;
                temp.next = current.next;
                current = temp.next;
                result++;
            }else {
                if(count==0){
                    flag=current;
                    count++;
                }

                current = current.next;
            }


        }
        current.forward.next =null;
        current.forward.forward=null;
        current.forward=null;
        ListNode origin=new ListNode(0);
        origin.next = current;
        while (origin.next!=null&&current.next!=null){
            if(current.val!= current.next.val){
                origin.next = current.next;
                current = current.next;
                result++;
            }
            if(origin.next!=null&&origin.next.next==null){
                result++;

            }
            if(current.val== current.next.val){
                while(current.next!=null&&current.val==current.next.val){
                    current = current.next;
                }
                origin.next = current.next;
                current = current.next;
                result++;
            }
        }

        return result+1;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode forward;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
            this.forward = null;
        }
    }


}

