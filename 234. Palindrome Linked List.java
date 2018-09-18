/*

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true

*/

// 利用慢指针和快指针找到链表的中心位置，同时将前半部分链表反转，最后判断两个链表的元素是否完全一样
class Solution {
        public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next, last = null;
        ListNode left, right;
        while (true) {

            // odd
            if (fast == null) {
                left = last;
                right = slow.next;
                break;
            }
            else if (fast.next == null) {
                left = slow;
                right = slow.next;
                slow.next = last;
                break;

            }
            ListNode temp = slow.next;
            slow.next = last;
            last = slow;
            slow = temp;
            fast = fast.next.next;
        }

        while (left != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

}
