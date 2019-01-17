/**
 * <a href = "https://leetcode.com/problems/middle-of-the-linked-list/submissions/">Problem here.</a>
 * Created by NubbY
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slowHead = head;
        ListNode fastHead = head;
        while (fastHead != null && fastHead.next != null) {
            fastHead = fastHead.next.next;
            slowHead = slowHead.next;
        }
        return slowHead;
    }
}
