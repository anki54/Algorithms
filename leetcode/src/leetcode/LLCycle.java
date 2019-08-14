package leetcode;

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class LLCycle {

	// Returns true if the given LL has a cycle.
	public static boolean hasCycle(ListNode head) {

		ListNode slow, fast;
		slow = fast = head;
		while (slow != null && slow.next != null 
				&& fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;

	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = head;
		System.out.println(" is linked List cyclic : " + hasCycle(head) );
		
		// Edge cases
		System.out.println(" is sinlgle node linked List cyclic : " + hasCycle(new ListNode(3)) );
		System.out.println(" is empty linked List cyclic : " + hasCycle(null) );
	}

}
