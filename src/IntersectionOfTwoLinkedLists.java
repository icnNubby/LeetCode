/**
 * <a href = "https://leetcode.com/problems/intersection-of-two-linked-lists/">Problem here.</a>
 */
public class IntersectionOfTwoLinkedLists {

    private ListNode iterateNtimesOnAList(ListNode head, int N) {
        ListNode headIterator = head;
        for (int i = 0; i < N; i++) headIterator = headIterator.next;
        return headIterator;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode rememberHeadA = headA;
        ListNode rememberHeadB = headB;

        int counterA = 0;
        int counterB = 0;

        while (headA != null) {
            headA = headA.next;
            counterA++;
        }
        while (headB != null) {
            headB = headB.next;
            counterB++;
        }

        headA = rememberHeadA;
        headB = rememberHeadB;

        if (counterA - counterB < 0)
            headB = iterateNtimesOnAList(rememberHeadB, (counterB - counterA));
        else if (counterA - counterB > 0)
            headA = iterateNtimesOnAList(rememberHeadA, counterA - counterB);

        ListNode intersectionNode = null;

        while (headA != null && headB != null) {
            //insane implementation (it actually requires references to be equal)
            if (headA == headB) {
                intersectionNode = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return intersectionNode;
    }
}
