package com.algos;

public class SortedLinkedList {
	
	Node head;
	
	class Node{
		int data;
		Node next;
		Node(int d) {data = d; next = null; }
	}

	
	Node reverse(Node head, int k){
		Node currentNode = head;
		int i =0;
		while(i<k && currentNode != null){
			int j = i;
			while(j<k-1 && currentNode != null){
				Node tempNode = currentNode.next;
				currentNode.next= currentNode.next.next;
				tempNode.next=currentNode;
				if (i==j){
					head = tempNode;
				}
				j++;
			}
			i++;
		}
		return head;
	}
	
	int compare(Node node1, Node node2)
    {
      //Your code here
      Node currNode1 = node1;
      Node currNode2 = node2;
      while(currNode1!=null && currNode2!=null){
      if ((currNode1==null && currNode2!=null) || (currNode1.data<currNode2.data)){
          return -1;
      }else if((currNode1!=null && currNode2==null) ||(currNode1.data>currNode2.data) ){
          return 1;
      }else{
          currNode1 = currNode1.next;
          currNode2 = currNode2.next;
      }
      }
      return 0;
    }
	
	void sortedInsert(Node newNode){
		Node currentHead= head;
		//boolean inserted = false;
		if(head == null || head.data>=newNode.data){
			head = newNode;
			newNode.next = currentHead;
			//inserted = true;
		}else {
//			while(currentHead.next!=null){
//				if(currentHead.next.data>newNode.data){
//					Node tempNode = currentHead.next;
//					newNode.next = tempNode;
//					currentHead.next=newNode;
//					//inserted = true;
//				}else{
//					currentHead = currentHead.next;
//				}
//			}
			while(currentHead.next!=null && currentHead.next.data<newNode.data){
				currentHead = currentHead.next;
			}
			
			newNode.next=currentHead.next;
			currentHead.next=newNode;
		}
//		if(!inserted){
//			currentHead.next=newNode;
//		}
	}
	
	public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
  
        /* 3. Make next of new Node as head */
        new_node.next = head;
  
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
 
    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
 
     /* Drier program to test above functions */
    public static void main(String args[])
    {
        SortedLinkedList llist = new SortedLinkedList();
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
         
        System.out.println("Given Linked List");
        llist.printList();
         
        llist.head = llist.reverse(llist.head, 9);
 
        System.out.println("Reversed list");
        llist.printList();
    }
}
