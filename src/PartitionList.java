/**
 * <a href = "https://leetcode.com/problems/partition-list/">Problem here.</a>
 * Created by NubbY
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {

        if (head == null) return head;

        ListNode lowerPartition = null;
        ListNode lowerHead = null;
        ListNode higherHead = null;
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            if (head.val < x) {
                if (lowerPartition == null) {
                    lowerPartition = head;
                    lowerHead = head;
                } else {
                    ListNode tmp = lowerPartition;
                    lowerPartition = head;
                    tmp.next = lowerPartition;
                }
                if (prev != null) {
                    prev.next = head.next;
                }
                lowerPartition.next = null;
            } else {
                if (higherHead == null) {
                    higherHead = head;
                }
                prev = head;
            }
            head = next;
        }

        if (lowerPartition != null)
            lowerPartition.next = higherHead;
        else
            lowerHead = higherHead;

        return lowerHead;
    }
}
