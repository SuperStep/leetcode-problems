public class Solution {
    public static ListNode removeZeroSumSublists(ListNode head) {
  
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        Map<Integer, ListNode> sumToNode = new HashMap<>();
        int sum = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            sum += node.val;
            sumToNode.put(sum, node);
        }
        
        sum = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            sum += node.val;
            node.next = sumToNode.get(sum).next;
        }
        
        return dummy.next;
    }
}