// 23. Merge k Sorted Lists
// Example:

// Input:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// Output: 1->1->2->3->4->4->5->6

// Definition for singly-linked list.
public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		} else {
			return mergeKLists(lists, 0, lists.length - 1);
		}

	}

	public ListNode mergeKLists(ListNode[] lists, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			ListNode list1 = mergeKLists(lists, left, mid);
			ListNode list2 = mergeKLists(lists, mid + 1, right);
			return merge2List2(list1, list2);
		}
		return lists[left];
	}

	public ListNode merge2List2(ListNode node1, ListNode node2) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while (node1 != null && node2 != null) {
			if (node1.val <= node2.val) {
				cur.next = node1;
				node1=node1.next;
			} else {
				cur.next = node2;
				node2=node2.next;
			}
			cur=cur.next;
		}
		if(node1!=null){
			cur.next=node1;
		}else{
			cur.next=node2;
		}
		return head.next;
	}
}