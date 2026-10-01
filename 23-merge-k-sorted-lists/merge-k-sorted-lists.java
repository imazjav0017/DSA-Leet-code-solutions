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
    public ListNode mergeKLists(ListNode[] lists) {
        int k=lists.length;
        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        for(int i=0;i<k;i++){
            ListNode x=lists[i];
            if(x!=null)pq.offer(x);
        }
        while(!pq.isEmpty()){
            ListNode x=pq.poll();
            curr.next=x;
            if(x.next!=null)pq.offer(x.next);
            curr=curr.next;
        }
        return dummy.next;
    }
}