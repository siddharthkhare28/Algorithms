package com.g4g.trees;

public class ArrayPreorder {
	
	public boolean checkIfArrayIsPreorder(int[] arr){
		boolean check = true;
		boolean isRightSubtreeStarted = false;
		int root  = arr[0];
		int currentNode = arr[0];
		int parent = 0;
		for(int i=1; i<arr.length; i++){
			if(isRightSubtreeStarted){
				if(arr[i]< root){
					return false;
				}
			}
			if(arr[i]<arr[i-1]){
				currentNode = arr[i];
				parent = arr[i-1];
			}else{
				int j = i-2;
				while(j>0){
					if(arr[i]<arr[j]){
						//parent = 
					}
				}
			}
		}
		return check;
	}

}
