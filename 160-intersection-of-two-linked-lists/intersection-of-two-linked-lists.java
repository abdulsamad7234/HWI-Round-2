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
        int lengthA = findLength(headA);
        int lengthB = findLength(headB);
        
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        int lengthDiff = 0;
        if(lengthA < lengthB){
            lengthDiff = lengthB - lengthA;
            while(lengthDiff > 0){
                ptr2 = ptr2.next;
                lengthDiff--;
            }
        }else{
            lengthDiff = lengthA - lengthB;
            while(lengthDiff > 0){
                ptr1 = ptr1.next;
                lengthDiff--;
            }
        }
        
        while(ptr1 != null && ptr2 != null){
            if(ptr1 == ptr2){
                return ptr1;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return null;
    }

    int findLength(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}