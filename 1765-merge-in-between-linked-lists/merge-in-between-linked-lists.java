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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ptr1 = list1;
        ListNode ptr2 = list1;
        for(int i = 0; i < a - 1; i++){
            ptr1 = ptr1.next;
        }
        for(int i = 0; i < b; i++){
            ptr2 = ptr2.next;
        }

        ListNode ptr3 = list2;
        while(ptr3.next != null){
            ptr3 = ptr3.next;
        }
        ptr1.next = list2;
        ptr3.next = ptr2.next;
        ptr2.next = null;
        return list1;
    }
}