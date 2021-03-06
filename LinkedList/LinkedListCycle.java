import java.util.HashSet;
import java.util.Set;

// 141. Linked List Cycle

// Given a linked list, determine if it has a cycle in it.

// To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) 
// in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

// Example 1:
// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where tail connects to the second node.

// Example 2:
// Input: head = [1,2], pos = 0
// Output: true
// Explanation: There is a cycle in the linked list, where tail connects to the first node.

// Example 3:
// Input: head = [1], pos = -1
// Output: false
// Explanation: There is no cycle in the linked list.

// Follow up:
// Can you solve it using O(1) (i.e. constant) memory?

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // HashSet 4 ms 37.1 MB
    public boolean hasCycle(ListNode head) {
        Set count = new HashSet<>();
        while (head != null) {
            if (count.contains(head)) {
                return true;
            }
            count.add(head);
            head = head.next;
        }
        return false;
    }

    // Two Pointers 0 ms 37.3 MB
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null) {
            if (fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}