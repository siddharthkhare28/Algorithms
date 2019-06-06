package com.g4g.trees;

public class RemoveNodesOnRootToLeafPathForLengthK {

	public static void deleteIfPathLengthIsLess(int k, Node n, Node parent, int inclination){
		if(k==1){
			return;
		}
		if(n.left==null && n.right==null){
			if(inclination == 0){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		if(n.left!=null){
			deleteIfPathLengthIsLess(k-1, n.left, n, 0);
		}if(n.right!=null){
			deleteIfPathLengthIsLess(k-1, n.right, n, 1);
		}
	}
	
	public static void deleteIfPathLengthIsLess(Tree t, int k){
		if(t.root.left!=null){
			deleteIfPathLengthIsLess(k-1, t.root.left, t.root, 0);
		}if(t.root.right!=null){
			deleteIfPathLengthIsLess(k-1, t.root.right, t.root, 1);
		}
	}
	
	public static  void printInorder(Node node) 
    {
        if (node != null) 
        {
            printInorder(node.left);
            System.out.print(node.val + " ");
            printInorder(node.right);
        }
    }
	
	public static void main(String[] args){
		 Tree tree = new Tree();
	        int k = 4;
	        tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	        tree.root.left.left.left = new Node(7);
	        tree.root.right.right = new Node(6);
	        tree.root.right.right.left = new Node(8);
	        System.out.println("The inorder traversal of original tree is : ");
	        printInorder(tree.root);
	        deleteIfPathLengthIsLess(tree, k);
	        System.out.println("");
	        System.out.println("The inorder traversal of modified tree is : ");
	        printInorder(tree.root);
	}
	
}

