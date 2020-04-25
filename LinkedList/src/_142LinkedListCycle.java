import java.util.HashSet;
import java.util.Set;

public class _142LinkedListCycle {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode cur = head;
        while (cur != null){
            if (visited.contains(cur))
                return cur;
            visited.add(cur);
            cur = cur.next;
        }
        return null;
    }
}
