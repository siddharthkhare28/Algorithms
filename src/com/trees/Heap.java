package com.trees;

public class Heap {

	public int maxSize;
	public int currSize;
	
	Tree[] arr;
	
	public Heap(int maxSize){
		this.maxSize = maxSize;
		arr = new Tree[maxSize];
	}
	
	public void trickleUp(int index){
		Tree temp = arr[index];
		while(index>0){
			int parent = (index-1)/2;
			if (temp.root.charFreq > arr[index].root.charFreq){
				
				arr[index] = arr[parent];
				index = parent;
			}else{
				break;
			}
		}
		arr[index] = temp;
	}
	
	public void trickleDown(int index){
		Tree temp = arr[index];
		while(index<currSize/2){
			int leftChild = 2*index + 1;
			int rightChild = 2*index + 2;
			int largerChild;
			if (rightChild<currSize && arr[rightChild].root.charFreq<arr[leftChild].root.charFreq){
				largerChild = rightChild;
			}else{
				largerChild = leftChild;
			}
			if(temp.root.charFreq<=arr[largerChild].root.charFreq){
				break;
			}
			arr[index] = arr[largerChild];
			index = largerChild;
		}
		arr[index] = temp;
	}
	
	public boolean add(Tree x){
		if(currSize==maxSize)
			return false;
		arr[currSize] = x;
		currSize++;
		trickleUp(currSize-1);
		return true;
	}
	
	public Tree remove(){
		Tree val = arr[0];
		arr[0] = arr[--currSize];
		trickleDown(0);
		return val;
	}
}
