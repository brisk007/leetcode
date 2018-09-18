/*

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

https://leetcode.com/problems/min-stack/description/
*/
class MinStack {

    /** initialize your data structure here. */
    private static class Node {
        private int val, min;
        private Node next;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }

    private Node head;

    public MinStack() {

    }

    public void push(int x) {
        if (head == null)
            head = new Node(x, x);
        else {
            Node tmp = head;
            head = new Node(x, Math.min(x, tmp.min));
            head.next = tmp;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
