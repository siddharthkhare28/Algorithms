package com.trees;

public class BinarySearchTree {
	
	Node root;
	
	public Node find(int key)
	{
		Node current = root;
		while(current!=null){
			if(current.iData==key){
				return current;
			}
			if(current.iData<key){
				current = current.leftNode;
			}
			if(current.iData>key){
				current = current.rightNode;
			}
		}
		return null;
		
	}
	public void insert(int id, String dd)
	{
		Node current = root;
		Node newNode = new Node(); // make new node
		newNode.iData = id; // insert data
		newNode.value = dd;
		if(root==null) // no node in root
		{	root = newNode;
			return;
		}
		Node parent;
		while (current!=null){
			parent = current;
			if(current.iData<id){
				current = current.leftNode;
				if (current == null){
					parent.leftNode = newNode;
					return;
				}
			}
			if(current.iData>id){
				current = current.rightNode;
				if (current == null){
					parent.rightNode = newNode;
					return;
				}
			}
		}
		
	}
	
	public void inOrder(Node localRoot)
	{
		if(localRoot != null)
		{
		inOrder(localRoot.leftNode);
		System.out.print(localRoot.iData + " ");
		inOrder(localRoot.rightNode);
		}
	}
	
	public void delete(int id)
	{
	}

}

class Node{
	
	int iData;
	String value;
	public Node leftNode;
	public Node rightNode;
}
