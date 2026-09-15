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
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode right=slow.next;
        slow.next=null;
        right=reverse(right);
        ListNode left=head;
        merge(left,right);
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
   void merge(ListNode left, ListNode right) {
    while (right != null) {
        ListNode leftNext = left.next;
        ListNode rightNext = right.next;

        left.next = right;
        right.next = leftNext;

        left = leftNext;
        right = rightNext;
    }
}
}