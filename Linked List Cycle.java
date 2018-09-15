
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */



/*
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        while ((fast != null) && (fast.next != null)){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if ((fast == null) || (fast.next == null)){
            return false;
        }
        return true;
    }
}

// 用两个指针，一个一次走两步，一个一次走一步，如果存在环，快的会追上慢的。

*/





public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode pre = head, cur = head.next, next;
        while(cur != null){
            if (cur.next == head)
                return true;
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return false;
    }
}

// 反转链表，如果存在环，会再次走到根节点。
