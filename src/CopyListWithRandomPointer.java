import java.util.HashMap;

/**
 * <a href = "https://leetcode.com/problems/copy-list-with-random-pointer">Problem here.</a>
 * Created by NubbY
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        HashMap<Integer, RandomListNode> listMappedByIndex = new HashMap<>();
        HashMap<RandomListNode, Integer> listMappedByNode = new HashMap<>();
        HashMap<Integer, RandomListNode> newListMappedByIndex = new HashMap<>();

        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode newHeadStored = newHead;
        int count = 0;

        listMappedByIndex.put(count, head);
        listMappedByNode.put(head, count);
        newListMappedByIndex.put(count, newHead);

        while (head.next != null) {
            head = head.next;
            newHead.next = new RandomListNode(head.label);
            newHead = newHead.next;
            count++;

            listMappedByIndex.put(count, head);
            listMappedByNode.put(head, count);
            newListMappedByIndex.put(count, newHead);
        }
        newHead.next = null;

        for (int i = 0; i < count + 1; i++) {
            newListMappedByIndex.get(i).random = newListMappedByIndex.get(listMappedByNode.get(listMappedByIndex.get(i).random));
        }

        return newHeadStored;
    }
}
