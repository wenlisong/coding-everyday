# -*- coding:utf-8 -*-
# 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # 返回合并后列表
    def Merge(self, pHead1, pHead2):
        # tmp1 = pHead1
        # tmp2 = pHead2
        Head = ListNode(0)
        tmp = Head
        while pHead1 and pHead2:
            if pHead1.val < pHead2.val:
                tmp.next = pHead1
                pHead1 = pHead1.next
            else:
                tmp.next = pHead2
                pHead2 = pHead2.next
            tmp = tmp.next
        if not pHead1:
            tmp.next = pHead2
        else:
            tmp.next = pHead1

        return Head.next  


def main():
    pass


if __name__ == "__main__":
    main()
