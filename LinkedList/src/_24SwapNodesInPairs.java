public class _24SwapNodesInPairs {
    public ListNode swapPairs(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null){
            ListNode l1 = pre.next;
            ListNode l2 = pre.next.next;
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            pre.next = l2;
            pre = l1;
        }
        return dummy.next;
    }
}
