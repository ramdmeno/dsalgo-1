/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {        
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<>((o1,o2) -> o1.val - o2.val);
        for(ListNode node: lists) {
            if(node != null)
                q.add(node);
        }
        
        ListNode dn = new ListNode(-1);
        ListNode cur = dn;
        while(!q.isEmpty()) {
            ListNode t = q.poll();
            if(t.next != null) {
                q.add(t.next);
            }
            cur.next = t;
            t.next = null;
            cur = cur.next;
        }
        return dn.next;
    }
}