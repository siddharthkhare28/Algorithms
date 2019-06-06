package com.g4g.trees;

public class CheckFullBinaryTreeOrNot {

	public static Boolean isFull(Node n){
		if(n.left!=null && n.right!=null){
			return isFull(n.left) && isFull(n.right);
		}
		if((n.left!=null && n.right==null)|| (n.left==null && n.right!=null)){
			return false;
		}
		if((n.left==null && n.right==null)|| (n.left==null && n.right==null)){
			return true;
		}
		return true;
	}
	
	public static void main(String args[]){
		Tree tree = new Tree();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.right = new Node(40);
        tree.root.left.left = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.left.left.left = new Node(80);
        tree.root.right.right = new Node(70);
        tree.root.left.left.right = new Node(90);
        tree.root.left.right.left = new Node(80);
        tree.root.left.right.right = new Node(90);
        tree.root.right.left.left = new Node(80);
        tree.root.right.left.right = new Node(90);
        tree.root.right.right.left = new Node(80);
        //tree.root.right.right.right = new Node(90);
          
        if(isFull(tree.root))
            System.out.print("The binary tree is full");
        else
            System.out.print("The binary tree is not full"); 
    }
	
	
}

class Node{
	Node left;
	Node right;
	int val;
	public Node(int val){
		this.val = val;
	}
}

class Tree{
	Node root;
	void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
