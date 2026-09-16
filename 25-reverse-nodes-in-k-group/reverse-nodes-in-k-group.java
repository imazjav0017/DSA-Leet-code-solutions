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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode groupPrev=dummy;
        while(true){
            ListNode kth=getKthNode(groupPrev,k);
            if(kth==null){
                break;
            }
            ListNode groupNext=kth.next;
            ListNode curr=groupPrev.next;
            ListNode prev=groupNext;
            while(curr!=groupNext){
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            ListNode oldStart=groupPrev.next;
            groupPrev.next=kth;
            groupPrev=oldStart;
        }
        return dummy.next;
    }
    ListNode getKthNode(ListNode curr,int k){
        while(k>0 && curr!=null){
            curr=curr.next;
            k--;
        }
        return curr;
    }
}