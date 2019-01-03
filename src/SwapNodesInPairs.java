/**
 * <a href = "https://leetcode.com/problems/swap-nodes-in-pairs/">Problem here.</a>
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode rememberHead = head;
        ListNode prev = null;
        ListNode next;
        while (head != null && head.next != null) {
            next = head.next.next;
            if (prev != null)
                prev.next = head.next;
            else
                rememberHead = head.next;
            prev = head;
            head.next.next = head;
            head = next;
        }
        if (prev != null) prev.next = head;
        return rememberHead;
    }
}
