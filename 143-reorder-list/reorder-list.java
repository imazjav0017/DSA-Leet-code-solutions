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
    void merge(ListNode list1, ListNode list2){
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        int next=1;
        while(list1!=null && list2!=null){
            if(next==1){
                curr.next=list1;
                list1=list1.next;
                next=2;
            }
            else{
                curr.next=list2;
                list2=list2.next;
                next=1;
            }
            curr=curr.next;
        }
        if(list1!=null)curr.next=list1;
        else if(list2!=null)curr.next=list2;
    }
}