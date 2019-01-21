# -*- coding:utf-8 -*-
# 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
class Solution:
    def __init__(self):
        self.stack = []
        self.minstack = []

    def push(self, node):
        self.stack.append(node)
        if not self.minstack or node <= self.minstack[-1]:
            self.minstack.append(node)

    def pop(self):
        if self.stack:
            if self.stack[-1] == self.minstack[-1]:
                self.stack.pop()
                self.minstack.pop()
            else:
                self.stack.pop()

    def top(self):
        if self.stack:
            return self.stack[-1]

    def min(self):
        if self.stack:
            return self.minstack[-1]
