package com.trees;

import java.util.HashMap;
import java.util.Map;

public class HuffmanTree {
	
	public Tree createHuffmanTree( String msg){
		Heap heap = new Heap(msg.length());
		char[] charArr = msg.toCharArray();
		Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
		for (char c:charArr){
			if(freqMap.containsKey(c)){
				int freq = freqMap.get(c)+1;
				freqMap.put(c, freq);
			}else{
				freqMap.put(c, 1);
			}
		}
		freqMap.forEach((c,f) -> {
			HuffmanNode node = new HuffmanNode();
			node.c = c;
			node.charFreq = f;
			Tree tree = new Tree();
			tree.root = node;
			heap.add(tree);
		});
		while(heap.currSize>1){
			HuffmanNode n1 = new HuffmanNode();
			Tree t1 = heap.remove();
			Tree t2 = heap.remove();
			Tree t3 = new Tree();
			int t3Freq = t1.root.charFreq+t2.root.charFreq;
			n1.charFreq = t3Freq;
			n1.left = t1.root;
			n1.right = t2.root;
			t3.root = n1;
			heap.add(t3);
		}
		return heap.remove();
	}
	
	public String getEncoding(char c, Tree t){
		String str = "";
		HuffmanNode left = t.root.left;
		HuffmanNode right = t.root.right;
		str = getEncoding("0", c, left);
		if (str.equalsIgnoreCase("-1")){
			str = getEncoding("1", c, right);
		}
		return str;
	}
	
	public String getEncoding(String initialVal, char c, HuffmanNode n){
		while(n.right!=null){
			if (n.left.c==c){
				initialVal = initialVal+0;
				return initialVal;
			}else{
				initialVal = initialVal+1;
				n=n.right;
			}
		}
		return "-1";
	}
	
	public static void main(String[] args){
		HuffmanTree h = new HuffmanTree();
		Tree t = h.createHuffmanTree("SUSIE SAYS IT IS EASY.");
		System.out.println(h.getEncoding('A', t));
		System.out.println(t.root.right.c);
		
	}
}


