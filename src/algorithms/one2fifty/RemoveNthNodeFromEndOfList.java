/* -*- coding: UTF-8 -*- */
package algorithms.one2fifty;

import test.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = null;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        if (p != null) {
            p = p.next;
            q = head;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        if (q == null) {
            return head.next;
        }
        q.next = q.next.next;
        return head;
    }
}