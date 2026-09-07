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
        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->
        Integer.compare(a.val,b.val));
        int k=lists.length;
        for(int i=0;i<k;i++){
            if(lists[i]!=null)
            pq.offer(lists[i]);
        }
        ListNode tail=null,head=null;
        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            if(head==null && tail==null){
                head=node;
                tail=node;
            }
            else{
                tail.next=node;
                tail=node;
            }
            if(node.next!=null){
                pq.offer(node.next);
            }

        }
        return head;
    }
}