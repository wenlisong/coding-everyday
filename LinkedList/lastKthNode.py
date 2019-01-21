# -*- coding:utf-8 -*-
# 输入一个链表，输出该链表中倒数第k个结点。

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def FindKthToTail(self, head, k):
        if k <1:
            return None
        cur = head
        next = head
        for i in range(k - 1):
            if next is None:
                return None
            next = next.next
        if next is None:
            return None
        while next.next:
            cur = cur.next
            next = next.next
        return cur


def main():
    head = ListNode(1)
    cur = head
    for i in range(2, 6):
        cur.next = ListNode(i)
        cur = cur.next
    k = 6
    solu = Solution()
    res = solu.FindKthToTail(head, k)
    print(res.val)

if __name__ == "__main__":
    main()