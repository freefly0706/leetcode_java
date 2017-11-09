package algorithms.one2fifty;

public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newListNode = new ListNode(0);
        ListNode swapedHead = newListNode;
        ListNode q = head;
        ListNode p = head.next;
        while (q != null && p != null) {
            newListNode.next = p;
            q.next = p.next;
            p.next = q;
            newListNode = q;
            q = q.next;
            if (q == null) {
                break;
            }
            p = q.next;
        }
        return swapedHead.next;
    }
}
