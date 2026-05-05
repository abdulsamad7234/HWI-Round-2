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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }

        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        k = k % len;
        if(k == 0){
            return head;
        }
        while(k > 0){
            ListNode tail = head;
            while(tail.next.next != null){
                tail = tail.next;
            }

            ListNode newHead = tail.next;
            tail.next = null;
            newHead.next = head;
            head = newHead;
            k--;
        }
        return head;
    }
}