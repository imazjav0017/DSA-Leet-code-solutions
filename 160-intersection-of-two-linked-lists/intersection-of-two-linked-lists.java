/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a=0,b=0;
        ListNode i=headA,j=headB;
        while(i.next!=null){
            i=i.next;
            a++;
        }
        while(j.next!=null){
            j=j.next;
            b++;
        }
        i=headA;
        j=headB;
        int diff=Math.abs(b-a);
        if(b>a){
            for(int x=0;x<diff;x++){
                j=j.next;
            }
        }
        else{
            for(int x=0;x<diff;x++){
                i=i.next;
            }
        }
        while(i!=j){
            i=i.next;
            j=j.next;
        }
        return i;
    }
}