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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode listPointer = head;
        ListNode firstPointer = head;
        ListNode secondPointer = head;
        int kThFromStart = 0 + k;
        int kThFromEnd = 0;
        int listLen = 0;
        int startVal = 0;
        int endVal = 0;
        int firstCounter = 0;
        int secondCounter = 0;
        
        while(listPointer != null){
            listLen++;    
            listPointer = listPointer.next;
        }
        
        kThFromEnd = (listLen) - k;
        
        while(firstPointer != null && firstCounter != kThFromStart - 1){
            firstPointer = firstPointer.next;
            firstCounter++;
        }
        
        
        startVal = firstPointer.val;
        
        while(secondPointer != null && secondCounter != kThFromEnd){
            secondPointer = secondPointer.next;
            secondCounter++;
        }
        
        endVal = secondPointer.val;
        
        firstPointer.val = endVal;
        secondPointer.val = startVal;
        
        
        return head;
    }
}