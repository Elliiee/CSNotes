public class _206ReverseLinkedList {
    // recursion
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;

        return newHead;
    }

    // insert head
    public ListNode reverseListII(ListNode head){
        ListNode newHead = new ListNode(-1);
        while (head != null){
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }
}
