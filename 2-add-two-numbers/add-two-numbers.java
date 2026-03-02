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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3=new ListNode(0);
        ListNode mover=l3;
        int carry=0;
        ListNode temp=l1;
        while(l1!=null || l2!=null || carry!=0){
             int sum=0;
             int x,y;
             if(l1!=null){
                x=l1.val;
             }else{
                x=0;
             }
             if(l2!=null){
                y=l2.val;
             }else{
                y=0;
             }
            sum=x+y+carry;
            carry=sum/10;
            int digit=(sum%10);
            mover.next=new ListNode(digit);
            mover=mover.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
           
        }
return l3.next;
    }
}