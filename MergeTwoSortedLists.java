/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null && l2 != null) return l2;
        if(l1 != null && l2 == null) return l1;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1,o2) -> o1.val - o2.val);
        pq.add(l1);
        pq.add(l2);
        
        ListNode dn = new ListNode(-1);
        ListNode cur = dn;
        while(!pq.isEmpty()) {
            ListNode t = pq.poll();
            if(t.next != null) {
                pq.add(t.next);
            }
            cur.next = t;
            t.next = null;
            cur = cur.next;
        }                    
        return dn.next;
    }
}