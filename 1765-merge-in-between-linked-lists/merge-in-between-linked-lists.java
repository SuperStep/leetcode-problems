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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0);
    dummy.next = list1;
    ListNode prev = dummy;

    // Move prev to the node before the 'a'th node
    for (int i = 0; i < a; i++) {
        prev = prev.next;
    }

    // Move curr to the 'b'th node
    ListNode curr = prev;
    for (int i = a; i <= b; i++) {
        curr = curr.next;
    }

    // Connect the 'a - 1'th node to the head of list2
    prev.next = list2;

    // Find the tail of list2 and connect it to the node after 'b'
    while (list2.next != null) {
        list2 = list2.next;
    }
    list2.next = curr.next;

    return dummy.next;
    }
}