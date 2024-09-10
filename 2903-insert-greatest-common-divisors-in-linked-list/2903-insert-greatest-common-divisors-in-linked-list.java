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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        while (second != null) {
            int gcd = calculateGCD(first.val, second.val);
            ListNode gcdNode = new ListNode(gcd);

            //Insert GCD node between first and second node
            first.next = gcdNode;
            gcdNode.next = second;

            //Move the pointers to the next set of nodes
            first = second;
            second = second.next;
        }

        return head;
    }

    private int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return calculateGCD(b, a % b);
    }
}