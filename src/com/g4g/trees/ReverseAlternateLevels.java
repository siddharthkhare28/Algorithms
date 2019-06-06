package com.g4g.trees;

public class ReverseAlternateLevels {
	
	private static int currSize = 0;
	static Node[] arr = new Node[100];
	
	public static void reverse(Node n, int level){
		if(n!= null && n.left!=null && n.right!=null){
			reverse(n.left, level+1);
			reverse(n.right, level+1);
		}
		if(level%2==1){
			int size = (int)Math.pow(2, level);
			arr[currSize++] = n;
			if(currSize == size){
				for(int i=0; i<size/2; i++){
					int temp = arr[i].val;
					arr[i].val = arr[size-1-i].val; 
					arr[size-1-i].val = temp;
				}
				currSize = 0;
			}
		}
	}

	public static void main(String[] args){
		Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(11);
        tree.root.right.left.left = new Node(12);
        tree.root.right.left.right = new Node(13);
        tree.root.right.right.left = new Node(14);
        tree.root.right.right.right = new Node(15);
        System.out.println("Inorder Traversal of given tree");
        tree.printInorder(tree.root);
 
        reverse(tree.root, 0);
        System.out.println("");
        System.out.println("");
        System.out.println("Inorder Traversal of modified tree");
        tree.printInorder(tree.root);
	}
	
}
