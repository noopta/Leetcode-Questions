public /**
        * Definition for singly-linked list. public class ListNode { int val; ListNode
        * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
        * ListNode next) { this.val = val; this.next = next; } }
        */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode firstCopy = head;
        ListNode secondCopy = head;
        int midPoint = 0;
        int listLen = 0;

        while (firstCopy != null) {
            listLen++;
            firstCopy = firstCopy.next;
        }

        if (listLen == 2) {
            head.next = null;
            return head;
        } else if (listLen == 1) {
            return null;
        }

        midPoint = listLen / 2;

        while (secondCopy != null && midPoint > 1) {
            midPoint--;
            secondCopy = secondCopy.next;
        }

        ListNode newNext = secondCopy.next.next;
        secondCopy.next = newNext;

        System.out.println(secondCopy.val);

        return head;
    }
}

class Delete_The_Middle_Node_Of_A_Linked_List {

}
