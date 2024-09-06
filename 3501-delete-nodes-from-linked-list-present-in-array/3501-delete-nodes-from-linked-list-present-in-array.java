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
    public ListNode modifiedList(int[] nums, ListNode head) {

        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }

        ListNode temp = new ListNode();
        ListNode current = temp;

        while (head != null) {
            if (!set.contains(head.val)) {
                current.next = head;
                current = current.next;
            }

            head = head.next;
        }
        

        current.next = null;
        return temp.next;
    }
}