package com.leetcode1;

import com.ListNode;

public class Test2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //哑节点dummy，使用dummy->next表示真正的头节点。这样可以避免处理头节点为空的边界问题
        ListNode dummyHead = new ListNode(0);
        //p和q初始化为链表l1和l2的头结点[游标] curr指向哑结点
        ListNode p = l1, q = l2, curr = dummyHead;
        //进位
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            //当前节点的下一个结点为真正的头结点
            curr.next = new ListNode(sum % 10);
            //同时当前节点的下一个结点为当前节点
            curr = curr.next;
            //链表l1和l2前进
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        //链表遍历结束，如果最后一位有进位，当前节点的下一个结点为1
        if(carry>0){
            curr.next=new ListNode(carry);
        }
        //返回哑结点的下一个结点为真正的返回链表
        return dummyHead.next;
    }

}
