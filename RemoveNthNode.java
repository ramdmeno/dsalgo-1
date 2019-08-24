/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n <= 0) return head; 
        ListNode dn = new ListNode(-1);
        dn.next = head;
        
        ListNode s = dn;
        ListNode f = dn;
        for(int i=0; i<=n && f !=null; i++) {
            f = f.next;   
        }
        while(f != null) {
            s = s.next;
            f = f.next;
        }
        s.next = s.next.next;
        return dn.next;
    }
    
}