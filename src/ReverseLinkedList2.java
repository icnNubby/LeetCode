/**
 * <a href = "https://leetcode.com/problems/reverse-linked-list-ii/">Problem here.</a>
 */
public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode rememberHead = head;
        ListNode startOfPath = null;
        ListNode nodeBeforeStart = null;
        ListNode nodeBeforeEnd = null;
        ListNode endOfPath = null;

        if (m == n) return rememberHead;
        ListNode prev = null;
        ListNode next = null;

        int counter = 0;
        while (counter < n && head != null) {
            counter++;

            if (counter == m - 1) nodeBeforeStart = head;
            if (counter == m) startOfPath = head;
            if (counter == n) nodeBeforeEnd = head;

            if (counter >= m && counter <= n) {
                if (head != null) {
                    next = head.next;
                    head.next = prev;
                    prev = head;
                    head = next;
                }
            } else {
                head = head.next;
            }

        }
        if (counter == n) endOfPath = head;
        if (startOfPath != null) {
            startOfPath.next = endOfPath;
        }
        if (nodeBeforeStart != null) {
            nodeBeforeStart.next = nodeBeforeEnd;
        }

        return (m == 1) ? nodeBeforeEnd : rememberHead;
    }
}
