# -*- coding:utf-8 -*-
# 输入一个链表，反转链表后，输出新链表的表头。

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # 返回ListNode
    def ReverseList(self, pHead):
        if not pHead or not pHead.next:
            return pHead
        
        cur = pHead
        next = pHead
        while pHead.next:
            cur = pHead.next
            cur.next = pHead
            pHead = cur
        return cur

def main():


if __name__ == "__main__":
    main()