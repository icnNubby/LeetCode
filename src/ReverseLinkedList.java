class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

/**
 * <a href = "https://leetcode.com/problems/reverse-linked-list/"> Problem here. </a>
 * @author Nubby
 *
 */

public class ReverseLinkedList {

	public ListNode reverseListRecursive(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode curNext = reverseListRecursive(head.next);
		head.next.next = head;
        head.next = null;
		return curNext;
	}

	public ListNode reverseListIteratively(ListNode head) {
	    ListNode prev = null;
	    ListNode curr = head;
	    while (curr != null) {
	        ListNode nextTemp = curr.next;
	        curr.next = prev;
	        prev = curr;
	        curr = nextTemp;
	    }
	    return prev;
	}

}
