package AlgoAssignement;

public class HW1 {
	
	class Node {
		int val;
		Node next;
		
		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
		
		public Node(int val) {
			this.val = val;
		}
	}
	
	
	public static void main(String[] args) {
		HW1 mainObj = new HW1();
		
		Node common = null;
		
		for (int i = 12; i < 16; i++) {
			common = mainObj.new Node(i, common);
		}
		/*
		 * headA : 2 -> 15 -> 14 -> 13 -> 12
		 * headB : 5 -> 4 -> 15 -> 14 -> 13 -> 12
		 */
		Node headA = mainObj.new Node(2, common);
		Node headB = mainObj.new Node(5, mainObj.new Node(4, common));
		
		System.out.println(findLink(headA, headB).val);
		
		System.out.println(findLink(headB, headA).val);
		
		
		
		headA = mainObj.new Node(2, null);
		
		headB = mainObj.new Node(3, headA);
		
		System.out.println(findLink(headA, headB).val);
		
	}


	private static Node findLink(Node headA, Node headB) {
		Node rootA = headA;
		Node rootB = headB;
		
		
		int lenA = 0;
		
		while(rootA != null) {
			lenA++;
			rootA = rootA.next;
		}
		
		int lenB = 0;
		
		while(rootB != null) {
			lenB++;
			rootB = rootB.next;
		}
		
		int count  = 0;
		
		if(lenA > lenB) {
			count = lenA - lenB;
			rootA = headA;
			rootB = headB;
		}
		else {
			count = lenB - lenA;
			rootA = headB;
			rootB = headA;
		}
		
		for (int i = 0; i < count; i++) {
			rootA = rootA.next;
		}
		
		while(rootA != null && rootB != null) {
			if(rootA == rootB) {
				return rootA;
			}
			
			rootA = rootA.next;
			rootB = rootB.next;
		}
		
		return null;
	}



}
