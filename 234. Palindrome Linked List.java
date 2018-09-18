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
