public class _109ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head){
        if (head == null) return null;
        if (head.next == null)
            return new TreeNode(head.val);

        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;
        preMid.next = null;

        TreeNode t = new TreeNode(mid.val);
        t.left = sortedListToBST(head);
        t.right = sortedListToBST(mid.next);

        return t;
    }

    private ListNode preMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = head;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }
}
