/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        else if (l1 == null) return l2;
        else if (l2 == null) return l1;
        ListNode root = new ListNode(0);

        ListNode last = root;
        while (true) {
            if (l1 == null) {
                last.next = l2;
                return root.next;
            }
            if (l2 == null) {
                last.next = l1;
                return root.next;
            }

            if (l1.val > l2.val) {
                ListNode t2 = l2.next;
                ListNode t1 = l1.next;
                last.next = l2;
                last = l2;
                l2 = t2;
            } else {
                ListNode t1 = l1.next;
                last.next = l1;
                last = l1;
                l1 = t1;
            }
        }
    }
}
