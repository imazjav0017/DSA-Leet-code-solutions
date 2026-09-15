class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 1. Get node immediately before left
        ListNode before = dummy;

        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        // 2. Reverse [left, right]
        ListNode curr = before.next;
        ListNode prev = null;

        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. Reconnect
        ListNode oldStart = before.next;

        before.next = prev;
        oldStart.next = curr;

        return dummy.next;
    }
}