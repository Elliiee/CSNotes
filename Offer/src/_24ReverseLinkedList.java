
public class _24ReverseLinkedList {
    public ListNode ReverseListIteration(ListNode head){
        ListNode newList = new ListNode(-1);
        while (head != null){
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }
}
