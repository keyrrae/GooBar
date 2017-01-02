package SortAndHeap;

import structures.ListNode;

import java.util.*;

/**
 * Created by xuanwang on 1/1/17.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for(ListNode l: lists){
            if(l != null){
                q.offer(l);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while(! q.isEmpty()){
            ListNode t = q.poll();
            if(t.next != null) {
                q.offer(t.next);
            }
            p.next = t;
            p = p.next;
        }
        return dummy.next;
    }
}
