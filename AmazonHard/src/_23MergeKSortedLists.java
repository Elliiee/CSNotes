import java.util.*;

public class _23MergeKSortedLists {
    // approach 1 brute force
    public ListNode mergeKListsI(ListNode[] lists){
        List<Integer> l = new ArrayList<>();

        // put all the values in the array list
        for (ListNode ln : lists){
            while (ln != null){
                l.add(ln.val);
                ln = ln.next;
            }
        }

        // sort the array list
        Collections.sort(l);

        ListNode head = new ListNode(0); // dummy head
        ListNode h = head; // create a new node and assign to dummy head for iteration purpose
        for (int i : l){
            ListNode t = new ListNode(i); // create a new node
            h.next = t;
            h = h.next;
        }
        h.next = null; // assign null to the last node

        return head.next; // return the real head which is the next one of the dummy head
    } //O(NlogN) ; O(N)


    // approach 2 compare one by one
    public ListNode mergeKListsII(ListNode[] lists){
        int min_index = 0;
        ListNode head = new ListNode(0);
        ListNode h = head;
        while (true){
            boolean isBreak = true; // mark whether or not iterated the whole list
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++){
                if (lists[i] != null){
                    if (lists[i].val < min){
                        min_index = i;
                        min = lists[i].val;
                    }
                    isBreak = false;
                }
            }
            if (isBreak)
                break;
            ListNode a = new ListNode(lists[min_index].val);
            h.next = a;
            h = h.next;
            lists[min_index] = lists[min_index].next;
        }
        h.next = null;
        return head.next;
    } // O(KN); O(N)


    // the same as approach 2 but not creating a new list node to store the result, only change the node.next to it
    public ListNode mergeKListsII_V2(ListNode[] lists){
        int min_index = 0;
        ListNode head = new ListNode(0);
        ListNode h = head;
        while (true){
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++){
                if (lists[i] != null){
                    if (lists[i].val < min){
                        min_index = i;
                        min = lists[i].val;
                    }
                    isBreak = false;
                }
            }
            if (isBreak){
                break;
            }
            h.next = lists[min_index];
            h = h.next;
            lists[min_index] = lists[min_index].next;
        }
        h.next = null;
        return head.next;
    } // O(KN); O(1);


    // approach 3: priority queue which is the optimized version of approach 2
    public ListNode mergeKListsIII(ListNode[] lists){
        Comparator<ListNode> cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };

        Queue<ListNode> q = new PriorityQueue<>(cmp);
        for (ListNode l : lists){
            if (l != null){
                q.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (!q.isEmpty()){
            point.next = q.poll();
            point = point.next;
            // see if the current list is empty, if not, add the next node to the queue
            ListNode next = point.next;
            if (next != null){
                q.add(next);
            }
        }
        return head.next;
    }

    // the same as the approach 3 but using lambda expression for comparator
    public ListNode mergeKListsIII_V2(ListNode[] lists){
        Queue<ListNode> q = new PriorityQueue<>((o1, o2) -> {
            return o1.val - o2.val;
        });
        for (ListNode l : lists){
            if (l != null){
                q.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (!q.isEmpty()){
            point.next = q.poll();
            point = point.next;
            // see if the current list is empty, if not, add the next node to the queue
            ListNode next = point.next;
            if (next != null){
                q.add(next);
            }
        }
        return head.next;
    }
    // for N nodes, every time in and out the queue needs log(k) time, so O(Nlogk)
    // space complexity: O(k) for priority queue


    // Approach 4 merge lists one by one
    // 0th combine with 1st and then the result list combine with 2nd... and keep going
    public ListNode mergeKListsIV(ListNode[] lists){
        if (lists.length == 1){
            return lists[0];
        }
        if (lists.length == 0){
            return null;
        }
        ListNode head = merge2Lists(lists[0], lists[1]); // so don't forget to check those 2 edge cases before it
        for (int i = 2; i < lists.length; i++){
            head = merge2Lists(head, lists[i]); // merge one list by one list
        }
        return head;
    }
    public ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0); // this dummy head will be used as pointer as well
        ListNode ans = head; // this ans node stay at the dummy head original position for getting the answer purpose
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        if (l1 == null){
            head.next = l2;
        }
        if (l2 == null){
            head.next = l1;
        }
        return ans.next; // the real first node of the result list
    } // O(KN); O(1)


    // approach 5 merge with divide and conquer
    // divide the k lists to k/2 part with 2 lists a group
    // 让两个不同的lists组合，在此基础上，再两两组合，最后成为一个, so only need log(K) times merge which is better than
    // approach 4
    public ListNode mergeKListsV(ListNode[] lists){
        if (lists.length == 0){
            return null;
        }
        int interval = 1;
        while (interval < lists.length){
            System.out.println(lists.length);
            for (int i = 0; i + interval < lists.length; i += interval*2){
                lists[i] = merge2Lists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    } // O(NlogK); O(1)
}
