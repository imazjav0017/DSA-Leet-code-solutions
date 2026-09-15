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
    ListNode merge(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        boolean isList1=true;
        while(list1!=null && list2!=null){
            if(isList1){
                tail.next=list1;
                list1=list1.next;
                isList1=false;
            }
            else{
                tail.next=list2;
                list2=list2.next;
                isList1=true;
            }
            tail=tail.next;
        }
        if(list1!=null)tail.next=list1;
        else tail.next=list2;
        return dummy.next;
    }
}