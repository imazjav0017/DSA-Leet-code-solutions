/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode current=dummy;
        for(int i=1;i<left;i++){
            current=current.next;
        }
        ListNode start=current.next;
        current.next=null;
        ListNode end=start,prev=null;
        for(int i=left;i<=right;i++){
            prev=end;
            end=end.next;
        }
        prev.next=null;
        ListNode x=start;
        start=reverse(start);
        current.next=start;
        x.next=end;
        return dummy.next;
    }
    ListNode reverse(ListNode head){
        ListNode prev=null,curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}