
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

/**
 * <a href = "https://leetcode.com/problems/remove-linked-list-elements/"> Problem here. </a>
 * @author Nubby
 *
 */
public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
        
        ListNode storedHead = head;
        if (storedHead == null) return null;
        while (storedHead != null && storedHead.val == val)  {
            storedHead = storedHead.next;
        }
        
        ListNode current = storedHead;
        
        if (current == null) return null;
        while (current.next != null) {
            if (current.next.val == val) 
                current.next = current.next.next; 
            else
                current = current.next;
        }
        return storedHead;
        
    }
}
