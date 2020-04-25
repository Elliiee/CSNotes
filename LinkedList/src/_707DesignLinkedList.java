import java.util.List;

public class _707DesignLinkedList {
    private ListNode head;

    public _707DesignLinkedList(){
        head = null;
    }

    public ListNode getNode(int index){
        ListNode cur = head;
        for (int i = 0; i < index && cur != null; i++){
            cur = cur.next;
        }
        return cur;
    }

    public ListNode getTail(){
        ListNode cur = head;
        while (cur != null && cur.next != null){
            cur = cur.next;
        }
        return cur;
    }

    public int getValue(int index){
        ListNode cur = getNode(index);
        return cur == null ? -1 : cur.val;
    }

    public void addAtHead(int val){
        ListNode cur = new ListNode(val);
        cur.next = head.next;
        head = cur;
        return;
    }

    public void addAtTail(int val){
        if (head == null){
            addAtHead(val);
            return;
        }
        ListNode prev = getTail();
        ListNode cur = new ListNode(val);
        prev.next = cur;

    }

    public void addAtIndex(int index, int val){
        if (index == 0){
            addAtHead(val);
            return;
        }
        ListNode prev = getNode(index-1);
        if (prev == null) return;
        ListNode cur = new ListNode(val);
        cur.next = prev.next;
        prev.next = cur;
    }

    public void deletAtIndex(int index){
        ListNode cur = getNode(index);
        if (cur == null) return;
        ListNode prev = getNode(index-1);
        ListNode next = cur.next;
        if (prev != null){
            prev.next = next;
        } else {
            head = next;
        }
    }
}
