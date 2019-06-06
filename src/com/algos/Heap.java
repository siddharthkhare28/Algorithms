package com.algos;

public class Heap {

	public int maxSize;
	public int currSize;
	
	int[] arr;
	
	public Heap(int maxSize){
		this.maxSize = maxSize;
		arr = new int[maxSize];
	}
	
	public void trickleUp(int index){
		int temp = arr[index];
		while(index>0){
			int parent = (index-1)/2;
			if (arr[parent] < arr[index]){
				
				arr[index] = arr[parent];
				index = parent;
			}else{
				break;
			}
		}
		arr[index] = temp;
	}
	
	public void trickleDown(int index){
		int temp = arr[index];
		while(index<currSize/2){
			int leftChild = 2*index + 1;
			int rightChild = 2*index + 2;
			int largerChild;
			if (rightChild<currSize && arr[rightChild]>arr[leftChild]){
				largerChild = rightChild;
			}else{
				largerChild = leftChild;
			}
			if(temp>=arr[largerChild]){
				break;
			}
			arr[index] = arr[largerChild];
			index = largerChild;
		}
		arr[index] = temp;
	}
	
	public boolean add(int x){
		if(currSize==maxSize)
			return false;
		arr[currSize] = x;
		currSize++;
		trickleUp(currSize-1);
		return true;
	}
	
	public int remove(){
		int val = arr[0];
		arr[0] = arr[--currSize];
		trickleDown(0);
		return val;
	}
}
