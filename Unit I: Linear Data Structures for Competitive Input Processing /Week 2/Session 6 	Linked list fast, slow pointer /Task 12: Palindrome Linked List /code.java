class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        // 1. Find middle of the linked list using fast & slow pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 2. Reverse the second half of the list
        ListNode secondHalfHead = reverseList(slow);
        
        // 3. Compare first half and second half
        ListNode firstHalfHead = head;
        ListNode p2 = secondHalfHead;
        boolean isPalindrome = true;
        while (p2 != null) {
            if (firstHalfHead.val != p2.val) {
                isPalindrome = false;
                break;
            }
            firstHalfHead = firstHalfHead.next;
            p2 = p2.next;
        }
        
        // 4. (Optional) Restore original list structure
        reverseList(secondHalfHead);
        
        return isPalindrome;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
