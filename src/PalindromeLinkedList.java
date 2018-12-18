/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/"> Problem here. </a>
 * @author icnNubby
 *
 */
public class PalindromeLinkedList {
	
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
	
    public boolean isPalindrome(ListNode head) {
    	ListNode fast = head;
    	ListNode slow = head;
        ListNode slowprev = null;
    	while (fast!= null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
        if (fast!= null) slow = slow.next;
    	fast = head;
    	slow = reverseListIteratively(slow);
    	while (slow != null) {
    		if (slow.val != fast.val) return false;
    		slow = slow.next;
    		fast = fast.next;
    	}
    	return true;
    }
    
}
