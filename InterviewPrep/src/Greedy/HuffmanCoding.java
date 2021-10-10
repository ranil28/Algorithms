package Greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffManNode implements Comparable<HuffManNode>{
	HuffManNode left;
	HuffManNode right;
	char ch;
	int val;
	
	public HuffManNode(int val, char ch, HuffManNode left, HuffManNode right) {
		this.val = val;
		this.ch = ch;
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(HuffManNode o) {
		return this.val - o.val;
	}
}

public class HuffmanCoding {
	static Map<Character, Integer>bits;
	
	
	public static void main(String[] args) {
		System.out.println(encode("BCCABBDDAECCBBAEDDCC"));
	}
	
	public static int encode(String s) {
		bits = new HashMap<>();
		Map<Character, Integer> freq = new HashMap<>();
		
		
		for (int i = 0; i < s.length(); i++) {
			freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
		}
		
		PriorityQueue<HuffManNode> pq = new PriorityQueue<>();
		
		for(Map.Entry<Character, Integer> entry : freq.entrySet()) {
			pq.add(new HuffManNode(entry.getValue(), entry.getKey(), null, null));
		}
		
		
		while(pq.size() > 1) {
			HuffManNode left = pq.poll();
			HuffManNode right = pq.poll();
			
			HuffManNode currNode = new HuffManNode(left.val + right.val, '-', left, right);
			pq.add(currNode);
		}
		
		getSize(pq.poll(), "");
		
		int size = 0;
		for(Map.Entry<Character, Integer> entry : freq.entrySet()) {
			Character ch = entry.getKey();
			int frequency = entry.getValue();
			int sizeOfChar = bits.get(ch);
			
			size += (frequency * sizeOfChar);
			
		}
		
		for(Map.Entry<Character, Integer> entry : bits.entrySet()) {
			size += (8 + entry.getValue());
		}
		
		return size;
		
		
		
		
	}

	private static void getSize(HuffManNode node, String s) {
		if (node.left == null && node.right == null) {
			bits.put(node.ch, s.length());
			return;
		}
		
		getSize(node.left, s + "0");
		getSize(node.right, s + "1");
		
		
	}

}
