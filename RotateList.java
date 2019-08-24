/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) { 
        if(head == null || head.next == null) return head;
        ListNode dn = new ListNode(-1);
        dn.next = head;
        
        int len = 0;
        ListNode f = dn;
        ListNode s = dn;
        while(f.next != null) {
            f = f.next;
            ++len;
        }
        
        for(int i=0; i<len-k%len; i++) 
            s = s.next;
        f.next = dn.next;
        dn.next = s.next;
        s.next = null;
                
        return dn.next;
    }
}