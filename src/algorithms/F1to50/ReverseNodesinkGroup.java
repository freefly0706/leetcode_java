package algorithms.F1to50;

public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode p = res, q = p;
        int count;
        while (true) {
            count = 0;
            while (count < k) {
                if (p.next != null) {
                    p = p.next;
                    count++;
                } else {
                    return res.next;
                }
            }
            ListNode q1 = q.next, p1 = q1.next, tmp;
            ListNode pNext = p.next;
            while (p1 != pNext) {
                tmp = p1.next;
                q1.next = tmp;
                p1.next = q.next;
                q.next = p1;
                p1 = tmp;
            }
            q = q1;
            p = q;
        }
    }
}
